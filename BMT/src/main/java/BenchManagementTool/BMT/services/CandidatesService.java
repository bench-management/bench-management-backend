package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepo;
import BenchManagementTool.BMT.models.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesService {

    @Autowired
    private CandidatesRepo candidateRepo;

    public List<Candidate> getAllCandidates() {
        return candidateRepo.findAll();
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    // Method to get employee data by MongoDB ID
    public Candidate getCandidateById(String id) {
        return candidateRepo.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
    }

    // Method to get employee data by empId using custom query method
    public Candidate getCandidateByEmpId(String empId) {
        return candidateRepo.findByEmpId(empId).orElseThrow(() -> new RuntimeException("Candidate not found with empId: " + empId));
    }
}
