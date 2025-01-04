package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.*;
import BenchManagementTool.BMT.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<CandidateDTO> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    public CandidateDTO getCandidateById(@PathVariable String id) {
        return candidateService.getCandidateById(id);
    }

    @PostMapping
    public CandidateDTO addCandidate(@RequestBody CandidateDTO dto) {
        return candidateService.addCandidate(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable String id) {
        candidateService.deleteCandidate(id);
    }
}
