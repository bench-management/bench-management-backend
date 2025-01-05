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

        // Create and save the interview
        Interview interview = EntityMapper.toInterview(dto, client, candidate);
        interview = interviewRepository.save(interview);

        // Update the candidate with the new interview ID
        if (candidate != null) {
            candidate.getInterviewIds().add(interview.getId());
            candidateRepository.save(candidate);
        }

        return EntityMapper.toInterviewDTO(interview);
    }

    public InterviewDTO updateInterview(String id, InterviewDTO dto) {
        Interview existingInterview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        Client client = clientRepository.findById(dto.getClientId()).orElse(null);
        Candidate newCandidate = candidateRepository.findById(dto.getCandidateId()).orElse(null);
        Candidate oldCandidate = existingInterview.getCandidate();

        // Update the interview details
        Interview updatedInterview = EntityMapper.toInterview(dto, client, newCandidate);
        updatedInterview.setId(existingInterview.getId());

        // If the candidate has changed, update both the old and new candidates
        if (newCandidate != null && !newCandidate.equals(oldCandidate)) {
            if (oldCandidate != null) {
                oldCandidate.getInterviewIds().remove(id); // Remove the interview ID from the old candidate
                candidateRepository.save(oldCandidate);
            }

            newCandidate.getInterviewIds().add(id); // Add the interview ID to the new candidate
            candidateRepository.save(newCandidate);
        }

        // Save the updated interview
        interviewRepository.save(updatedInterview);

        return EntityMapper.toInterviewDTO(updatedInterview);
    }

    public void deleteInterview(String id) {
        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        Candidate candidate = interview.getCandidate();

        if (candidate != null) {
            candidate.getInterviewIds().remove(id); // Remove the interview ID from the candidate
            candidateRepository.save(candidate);
        }

        // Delete the interview
        interviewRepository.deleteById(id);
    }
}
