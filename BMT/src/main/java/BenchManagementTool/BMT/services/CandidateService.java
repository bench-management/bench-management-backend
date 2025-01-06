package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepository;
import BenchManagementTool.BMT.Repo.ClientRepository;
import BenchManagementTool.BMT.Repo.InterviewRepository;
import BenchManagementTool.BMT.dto.*;
import BenchManagementTool.BMT.models.*;
import BenchManagementTool.BMT.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(candidate -> {
                    List<Interview> interviews = candidate.getInterviewIds() != null ? interviewRepository.findAllById(candidate.getInterviewIds()) : List.of();
                    return EntityMapper.toCandidateDTO(candidate, interviews);
                })
                .collect(Collectors.toList());
    }

    public CandidateDTO getCandidateById(String id) {
        Optional<Candidate> candidateOpt = candidateRepository.findById(id);
        if (candidateOpt.isEmpty()) {
            return null;
        }

        Candidate candidate = candidateOpt.get();
        List<Interview> interviews = interviewRepository.findAllById(candidate.getInterviewIds());

        return EntityMapper.toCandidateDTO(candidate, interviews);
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
        return EntityMapper.toCandidateDTO(savedCandidate, List.of());
    }


    public CandidateDTO updateCandidate(String id, CandidateDTO dto) {
        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Candidate updatedCandidate = EntityMapper.toCandidate(dto, client);

        updatedCandidate.setId(existingCandidate.getId());
        updatedCandidate.setInterviewIds(existingCandidate.getInterviewIds());

        List<Interview> interviews = interviewRepository.findAllById(updatedCandidate.getInterviewIds());

        return EntityMapper.toCandidateDTO(candidateRepository.save(updatedCandidate), interviews);
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
                .map(candidate -> {
                    List<Interview> interviews = candidate.getInterviewIds() != null
                            ? interviewRepository.findAllById(candidate.getInterviewIds())
                            : List.of();
                    return EntityMapper.toCandidateDTO(candidate, interviews);
                })
                .collect(Collectors.toList());
    }

}
