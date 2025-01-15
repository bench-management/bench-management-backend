package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.MentorDTO;
import BenchManagementTool.BMT.mappers.EntityMapper;
import BenchManagementTool.BMT.models.Mentor;
import BenchManagementTool.BMT.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/mentors")
public class MentorController {
    @Autowired
    private MentorService mentorService;

    // Register a new mentor
    @PostMapping("/register")
    public MentorDTO registerMentor(@RequestBody MentorDTO mentorDTO) {
        return mentorService.registerMentor(mentorDTO);
    }

    @GetMapping
    public List<MentorDTO> getAllMentors() {
        return mentorService.getAllMentors();
    }

}
