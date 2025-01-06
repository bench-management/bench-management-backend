package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.FeedbackDTO;
import BenchManagementTool.BMT.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    // Add feedback
    @PostMapping("/add")
    public FeedbackDTO addFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.saveFeedback(feedbackDTO);
    }

    // Get feedback for a specific candidate
    @GetMapping("/candidate/{candidateId}")
    public List<FeedbackDTO> getFeedbackForCandidate(@PathVariable int candidateId) {
        return feedbackService.getFeedbackByCandidateId(candidateId);
    }
}
