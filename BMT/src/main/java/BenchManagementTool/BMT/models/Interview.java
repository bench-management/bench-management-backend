package BenchManagementTool.BMT.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "interviews")
public class Interview {

    @Id
    private String interviewId; // Unique identifier for the interview

    private String clientId; // Client associated with the interview
    private InterviewStatus interviewStatus; // Enum for the interview status
    private String interviewerName; // Name of the interviewer
    private String project; // Associated project
    private String clientRequirement; // Client's requirement details
    private String accoliteHiringManager; // Accolite hiring manager
    private String clientHiringManager; // Client hiring manager
    private String department; // Associated department
    private List<String> comments; // List of comments for the interview

    public enum InterviewStatus {
        SCHEDULED,
        ONGOING,
        REJECTED,
        SELECTED
    }

    private Candidate candidateId; // Full Candidate object stored internally

    private String candidateIdString; // Transient field for JSON input/output

    public String getCandidateIdString() {
        return this.candidateIdString;
    }

    public void setCandidateIdString(String candidateIdString) {
        this.candidateIdString = candidateIdString;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Candidate candidateId) {
        this.candidateId = candidateId;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getClientRequirement() {
        return clientRequirement;
    }

    public void setClientRequirement(String clientRequirement) {
        this.clientRequirement = clientRequirement;
    }

    public String getAccoliteHiringManager() {
        return accoliteHiringManager;
    }

    public void setAccoliteHiringManager(String accoliteHiringManager) {
        this.accoliteHiringManager = accoliteHiringManager;
    }

    public String getClientHiringManager() {
        return clientHiringManager;
    }

    public void setClientHiringManager(String clientHiringManager) {
        this.clientHiringManager = clientHiringManager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
