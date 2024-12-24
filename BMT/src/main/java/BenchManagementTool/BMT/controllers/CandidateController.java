package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.models.Candidates;
import BenchManagementTool.BMT.services.CandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidatesService candidatesService;

    @GetMapping
    public ResponseEntity<List<Candidates>> getAllCandidates() {
        List<Candidates> candidates = candidatesService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    @PostMapping
    public ResponseEntity<Candidates> createCandidate(@RequestBody Candidates candidate) {
        System.out.println("post request: " + candidate.getName());
        Candidates createdCandidate = candidatesService.createCandidate(candidate);
        return ResponseEntity.status(201).body(createdCandidate);
    }
}
