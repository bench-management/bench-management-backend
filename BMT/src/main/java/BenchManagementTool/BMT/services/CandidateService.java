package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepository;
import BenchManagementTool.BMT.Repo.ClientRepository;
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

    public List<CandidateDTO> getAllCandidates() {
        return candidateRepository.findAll().stream()
                .map(EntityMapper::toCandidateDTO)
                .collect(Collectors.toList());
    }

    public CandidateDTO getCandidateById(String id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        return candidate.map(EntityMapper::toCandidateDTO).orElse(null);
    }

    public CandidateDTO addCandidate(CandidateDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Candidate candidate = EntityMapper.toCandidate(dto, client);
        return EntityMapper.toCandidateDTO(candidateRepository.save(candidate));
    }

    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }
}