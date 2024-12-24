
package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.models.Candidates;
import BenchManagementTool.BMT.services.CandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class CandidateController {

    @Autowired
    private CandidatesService candidatesService;

    @GetMapping("/api/candidates/data")
    public List<Candidates> getAllCandidates() {
        List<Candidates> candidates = candidatesService.getAllCandidates();
        System.out.println(candidates);
        return candidates;

    }

    @PostMapping("/api/candidates")
    public Candidates createCandidate(@RequestBody Candidates candidate) {
        Candidates createdCandidate = candidatesService.createCandidate(candidate);
        return createdCandidate;
    }
}
