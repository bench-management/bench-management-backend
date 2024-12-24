package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepo;
import BenchManagementTool.BMT.models.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesService {

    @Autowired
    private CandidatesRepo candidatesRepo;

    public List<Candidates> getAllCandidates() {
        return candidatesRepo.findAll();
    }

    public Candidates createCandidate(Candidates candidate) {
        System.out.println("candidate received: " + candidate.getName());
        return candidatesRepo.save(candidate);
    }
}
