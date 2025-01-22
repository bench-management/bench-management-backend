package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepository;
import BenchManagementTool.BMT.Repo.ClientRepository;
import BenchManagementTool.BMT.Repo.InterviewRepository;
import BenchManagementTool.BMT.dto.*;
import BenchManagementTool.BMT.models.*;
import BenchManagementTool.BMT.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    @Autowired
    private CandidatesRepository candidateRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    public List<CandidateDTO> getAllCandidates() {
        return candidateRepository.findAll().stream()
                .map(EntityMapper::toCandidateDTO)
                .collect(Collectors.toList());
    }

    public CandidateDTO getCandidateById(String id) {
        Optional<Candidate> candidateOpt = candidateRepository.findById(id);
        if (candidateOpt.isEmpty()) {
            return null;
        }

        Candidate candidate = candidateOpt.get();
        return EntityMapper.toCandidateDTO(candidate);
    }

    public CandidateDTO addCandidate(CandidateDTO dto) {
        Client client = null;

        if (dto.getClientId() != null) {
            // Attempt to find the client if a clientId is provided
            client = clientRepository.findById(dto.getClientId()).orElse(null);
        }

        // Map the candidate with or without the client
        Candidate candidate = EntityMapper.toCandidate(dto, client);

        // Save the candidate to the repository
        Candidate savedCandidate = candidateRepository.save(candidate);

        // No interviews to fetch during creation; empty list passed
        return EntityMapper.toCandidateDTO(savedCandidate);
    }


    public CandidateDTO updateCandidate(String id, CandidateDTO dto) {
        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Candidate updatedCandidate = EntityMapper.toCandidate(dto, client);

        updatedCandidate.setId(existingCandidate.getId());
        updatedCandidate.setInterviewIds(existingCandidate.getInterviewIds());

        return EntityMapper.toCandidateDTO(candidateRepository.save(updatedCandidate));
    }

    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }

    public List<CandidateDTO> searchCandidates(String searchTerm) {
        List<Candidate> candidates;

        if (searchTerm == null || searchTerm.isEmpty()) {
            // If searchTerm is empty or null, return all candidates
            candidates = candidateRepository.findAll();
        } else {
            // Perform the search based on the provided searchTerm
            List<Candidate> candidatesByEmpId = candidateRepository.findByEmpIdStartingWithIgnoreCase(searchTerm);
            List<Candidate> candidatesByName = candidateRepository.findByNameStartingWithIgnoreCase(searchTerm);

            // Combine results, ensuring no duplicates
            candidatesByName.addAll(candidatesByEmpId);

            // Remove duplicates (if any)
            candidates = candidatesByName.stream().distinct().toList();
        }

        // Map to CandidateDTO and include associated interviews
        return candidates.stream()
                .map(EntityMapper::toCandidateDTO)
                .collect(Collectors.toList());
    }

    //to update remarks of selected user
    public CandidateDTO updateRemarks(String id, List<String> remarks) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found with id: " + id));
        candidate.setRemarks(remarks); // Update the remarks
        Candidate updatedCandidate = candidateRepository.save(candidate); // Save the updated candidate
        return EntityMapper.toCandidateDTO(updatedCandidate); // Return the updated DTO
    }


    public Map<YearMonth, Long> getHistoricalMonthWiseBenchCount() {
        List<Candidate> allCandidates = candidateRepository.findAll();

        Map<YearMonth, Long> monthWiseBenchCount = new HashMap<>();

        for (Candidate candidate : allCandidates) {
            if (candidate.getBenchStartDate() != null) {
                Date startDate = candidate.getBenchStartDate();
                Date endDate = candidate.getOnboardingDate() != null ? candidate.getOnboardingDate() : new Date();

                YearMonth startMonth = YearMonth.from(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                YearMonth endMonth = YearMonth.from(endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

                // Iterate through all months from start to end
                while (!startMonth.isAfter(endMonth)) {
                    monthWiseBenchCount.put(startMonth, monthWiseBenchCount.getOrDefault(startMonth, 0L) + 1);
                    startMonth = startMonth.plusMonths(1);
                }
            }
        }
        return monthWiseBenchCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }



    public Map<String, Long> getHistoricalWeekWiseBenchCount() {
        List<Candidate> allCandidates = candidateRepository.findAll();
        Map<String, Long> weekWiseBenchCount = new HashMap<>();

        for (Candidate candidate : allCandidates) {
            if (candidate.getBenchStartDate() != null) {
                LocalDate startDate = candidate.getBenchStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate endDate = candidate.getOnboardingDate() != null
                        ? candidate.getOnboardingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                        : LocalDate.now();

                while (!startDate.isAfter(endDate)) {
                    String weekKey = getFormattedWeekKey(startDate);
                    weekWiseBenchCount.put(weekKey, weekWiseBenchCount.getOrDefault(weekKey, 0L) + 1);
                    startDate = startDate.plusDays(7);
                }
            }
        }

        fillWeeksWithZeroCounts(weekWiseBenchCount);

        // Sorting the map by week keys (ascending order)
        return weekWiseBenchCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private String getFormattedWeekKey(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int year = date.getYear();
        int month = date.getMonthValue();
        int weekOfMonth = date.get(weekFields.weekOfMonth());
        return String.format("%d-%02d-week%d", year, month, weekOfMonth);
    }

    private void fillWeeksWithZeroCounts(Map<String, Long> weekWiseBenchCount) {
        LocalDate today = LocalDate.now();
        LocalDate start = today.withDayOfMonth(1).minusMonths(4); // Adjust range if needed
        LocalDate end = today;

        while (!start.isAfter(end)) {
            String weekKey = getFormattedWeekKey(start);
            weekWiseBenchCount.putIfAbsent(weekKey, 0L);
            start = start.plusDays(7);
        }
    }

}
