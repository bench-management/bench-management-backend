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


    public Candidate updateCandidate(Candidate updatedCandidate) {
        // Fetch the existing candidate by empId
        Candidate existingCandidate = candidateRepo.findByEmpId(updatedCandidate.getEmpId())
                .orElseThrow(() -> new RuntimeException("Candidate not found with empId: " + updatedCandidate.getEmpId()));

        existingCandidate.setName(updatedCandidate.getName());
        existingCandidate.setSkill(updatedCandidate.getSkill());
        existingCandidate.setPastExperience(updatedCandidate.getPastExperience());
        existingCandidate.setBaseLocation(updatedCandidate.getBaseLocation());
        existingCandidate.setStatus(updatedCandidate.getStatus());
        existingCandidate.setClientId(updatedCandidate.getClientId());
        existingCandidate.setTentativeOnboardingDate(updatedCandidate.getTentativeOnboardingDate());
        existingCandidate.setRemarks(updatedCandidate.getRemarks());
        existingCandidate.setAccoliteDoj(updatedCandidate.getAccoliteDoj());
        existingCandidate.setOnBench(updatedCandidate.isOnBench());
        existingCandidate.setBenchStartDate(updatedCandidate.getBenchStartDate());
        existingCandidate.setLwdInAccolite(updatedCandidate.getLwdInAccolite());
        existingCandidate.setMentorshipRating(updatedCandidate.getMentorshipRating());
        existingCandidate.setMentorId(updatedCandidate.getMentorId());
        existingCandidate.setProjectType(updatedCandidate.getProjectType());
        existingCandidate.setProjectAllocationStatus(updatedCandidate.getProjectAllocationStatus());
        existingCandidate.setCurrentLocation(updatedCandidate.getCurrentLocation());
        existingCandidate.setMentorship(updatedCandidate.isMentorship());
        existingCandidate.setThLink(updatedCandidate.getThLink());
        existingCandidate.setSelectedDate(updatedCandidate.getSelectedDate());
        existingCandidate.setOnboardingDate(updatedCandidate.getOnboardingDate());
        existingCandidate.setInterviewIds(updatedCandidate.getInterviewIds());

        // Save the updated candidate back to the repository
        return candidateRepo.save(existingCandidate);
    }



}
