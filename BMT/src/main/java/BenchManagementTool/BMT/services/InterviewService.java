package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepository;
import BenchManagementTool.BMT.Repo.ClientRepository;
import BenchManagementTool.BMT.Repo.InterviewRepository;
import BenchManagementTool.BMT.dto.InterviewDTO;
import BenchManagementTool.BMT.mappers.EntityMapper;
import BenchManagementTool.BMT.models.Candidate;
import BenchManagementTool.BMT.models.Client;
import BenchManagementTool.BMT.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CandidatesRepository candidateRepository;

    public List<InterviewDTO> getAllInterviews() {
        return interviewRepository.findAll().stream()
                .map(EntityMapper::toInterviewDTO)
                .collect(Collectors.toList());
    }

    public InterviewDTO getInterviewById(String id) {
        Optional<Interview> interview = interviewRepository.findById(id);
        return interview.map(EntityMapper::toInterviewDTO).orElse(null);
    }

    public InterviewDTO addInterview(InterviewDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Candidate candidate = candidateRepository.findById(dto.getCandidateId()).orElse(null);
        Interview interview = EntityMapper.toInterview(dto, client, candidate);
        return EntityMapper.toInterviewDTO(interviewRepository.save(interview));
    }

    public void deleteInterview(String id) {
        interviewRepository.deleteById(id);
    }
}
