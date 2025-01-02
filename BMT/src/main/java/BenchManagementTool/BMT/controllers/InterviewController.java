package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.models.Interview;
import BenchManagementTool.BMT.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
@CrossOrigin
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.listAllInterviews();
    }

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        System.out.println(interview);
        return interviewService.createInterview(interview);
    }

    @GetMapping("/id/{interviewId}")
    public Interview getInterviewById(@PathVariable String interviewId) {
        return interviewService.getInterviewById(interviewId);
    }

    @GetMapping("/candidate/{candidateId}")
    public List<Interview> getInterviewsByCandidateId(@PathVariable String candidateId) {
        return interviewService.getInterviewsByCandidateId(candidateId);
    }

    @GetMapping("/client/{clientId}")
    public List<Interview> getInterviewsByClientId(@PathVariable String clientId) {
        return interviewService.getInterviewsByClientId(clientId);
    }

    @DeleteMapping("/id/{interviewId}")
    public void deleteInterviewById(@PathVariable String interviewId) {
        interviewService.deleteInterviewById(interviewId);
    }

    @PutMapping("/id/{interviewId}")
    public Interview updateInterviewById(@PathVariable String interviewId, @RequestBody Interview interview) {
        return interviewService.updateInterviewById(interviewId, interview);
    }
}
