package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.FeedbackRepository;
import BenchManagementTool.BMT.Repo.MentorRepository;
import BenchManagementTool.BMT.dto.FeedbackDTO;
import BenchManagementTool.BMT.mappers.EntityMapper;
import BenchManagementTool.BMT.models.Feedback;
import BenchManagementTool.BMT.models.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private EntityMapper feedbackMapper;

    public FeedbackDTO saveFeedback(FeedbackDTO feedbackDTO) {
        // Validate mentor existence
        Mentor mentor = mentorRepository.findById(feedbackDTO.getMentorId())
                .orElseThrow(() -> new RuntimeException("Mentor not found with ID: " + feedbackDTO.getMentorId()));

        Feedback feedback = feedbackMapper.toFeedback(feedbackDTO);
        feedback.setMentor(mentor);
        feedback = feedbackRepository.save(feedback);

        return feedbackMapper.toFeedbackDTO(feedback);
    }

    public List<FeedbackDTO> getFeedbackByCandidateId(int candidateId) {
        List<Feedback> feedbackList = feedbackRepository.findByCandidateId(candidateId);
        if (feedbackList.isEmpty()) {
            throw new RuntimeException("No feedback found for candidate with ID: " + candidateId);
        }
        return feedbackList.stream()
                .map(feedbackMapper::toFeedbackDTO)
                .collect(Collectors.toList());
    }

}
