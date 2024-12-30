package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepo;
import BenchManagementTool.BMT.Repo.InterviewRepo;
import BenchManagementTool.BMT.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepo interviewRepository;

    @Autowired
    private CandidatesRepo candidateRepository;

    public List<Interview> listAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview createInterview(Interview interview) {

        // Validate the employeeId (empId) exists in the Candidate collection
        String empId = interview.getEmployeeId();
        candidateRepository.findByEmpId(empId).orElseThrow(() ->
                new RuntimeException("Candidate not found with empId: " + empId));

        return interviewRepository.save(interview);
    }

    public Interview getInterviewById(String interviewId) {
        return interviewRepository.findById(interviewId)
                .orElseThrow(() -> new RuntimeException("Interview not found with ID: " + interviewId));
    }

    public List<Interview> getInterviewsByEmployeeId(String employeeId) {
        return interviewRepository.findByEmployeeId(employeeId);
    }

    public List<Interview> getInterviewsByClientId(String clientId) {
        return interviewRepository.findByClientId(clientId);
    }

    public void deleteInterviewById(String interviewId) {
        if (!interviewRepository.existsById(interviewId)) {
            throw new RuntimeException("Interview not found with ID: " + interviewId);
        }
        interviewRepository.deleteById(interviewId);
    }

    public Interview updateInterviewById(String interviewId, Interview updatedInterview) {
        Interview existingInterview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new RuntimeException("Interview not found with ID: " + interviewId));


        if (updatedInterview.getEmployeeId() != null) {
            String empId = updatedInterview.getEmployeeId();
            candidateRepository.findByEmpId(empId).orElseThrow(() ->
                    new RuntimeException("Candidate not found with empId: " + empId));
            existingInterview.setEmployeeId(empId);
        }

        if (updatedInterview.getClientId() != null) {
            existingInterview.setClientId(updatedInterview.getClientId());
        }
        if (updatedInterview.getInterviewStatus() != null) {
            existingInterview.setInterviewStatus(updatedInterview.getInterviewStatus());
        }
        if (updatedInterview.getInterviewerName() != null) {
            existingInterview.setInterviewerName(updatedInterview.getInterviewerName());
        }
        if (updatedInterview.getProject() != null) {
            existingInterview.setProject(updatedInterview.getProject());
        }
        if (updatedInterview.getClientRequirement() != null) {
            existingInterview.setClientRequirement(updatedInterview.getClientRequirement());
        }
        if (updatedInterview.getAccoliteHiringManager() != null) {
            existingInterview.setAccoliteHiringManager(updatedInterview.getAccoliteHiringManager());
        }
        if (updatedInterview.getClientHiringManager() != null) {
            existingInterview.setClientHiringManager(updatedInterview.getClientHiringManager());
        }
        if (updatedInterview.getDepartment() != null) {
            existingInterview.setDepartment(updatedInterview.getDepartment());
        }
        if (updatedInterview.getComments() != null) {
            existingInterview.setComments(updatedInterview.getComments());
        }

        return interviewRepository.save(existingInterview);
    }
}
