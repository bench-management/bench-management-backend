package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.InterviewDTO;
import BenchManagementTool.BMT.models.Interview;
import BenchManagementTool.BMT.services.InterviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @GetMapping
    public List<InterviewDTO> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public InterviewDTO getInterviewById(@PathVariable String id) {
        return interviewService.getInterviewById(id);
    }

    @PostMapping
    public InterviewDTO addInterview(@RequestBody InterviewDTO dto) {
        return interviewService.addInterview(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewDTO> updateInterview(@PathVariable String id, @RequestBody InterviewDTO dto) {
        return ResponseEntity.ok(interviewService.updateInterview(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable String id) {
        interviewService.deleteInterview(id);
    }
}
