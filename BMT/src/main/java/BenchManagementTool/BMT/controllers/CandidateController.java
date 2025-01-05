package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.*;
import BenchManagementTool.BMT.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @PutMapping("/{id}")
    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable String id, @RequestBody CandidateDTO dto) {
        return ResponseEntity.ok(candidateService.updateCandidate(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable String id) {
        candidateService.deleteCandidate(id);
    }

    @GetMapping("/search")
    public List<CandidateDTO> searchCandidate(@RequestParam String searchTerm) {
        return candidateService.searchCandidates(searchTerm);
    }
}
