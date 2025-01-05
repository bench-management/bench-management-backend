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
        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Candidate candidate = EntityMapper.toCandidate(dto, client);
        Candidate savedCandidate = candidateRepository.save(candidate);

        // No interviews to fetch during creation; empty list passed
        return EntityMapper.toCandidateDTO(savedCandidate, List.of());
    }

    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }
}
