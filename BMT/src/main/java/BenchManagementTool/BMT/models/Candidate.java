package BenchManagementTool.BMT.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "candidates")
public class Candidate {

    @Id
    public String id;
    private String empId;
    private String name;
    private String skill;
    private int pastExperience; // Experience in years before joining the company
    private String baseLocation;
    private String status; // e.g., Active, On Bench, Allocated
    private String clientId; // If allocated
    private Date tentativeOnboardingDate;
    private String remarks;
    private Date accoliteDoj;
    private boolean onBench; // Yes/No
    private Date benchStartDate;
    private Date lwdInAccolite; // Last Working Date
    private int mentorshipRating;
    private String mentorId; // if mentorship
    private String projectType;
    private String projectAllocationStatus;
    private String currentLocation;
    private boolean mentorship; // Yes/No
    private String thLink; // Tech Hiring link
    private Date selectedDate;
    private Date onboardingDate;
    private String interviewIds; // foreign key for interviews conducted

    public Candidate() {}

    public Candidate(String empId, String name, String skill, int pastExperience, String baseLocation, String status, String clientId, Date tentativeOnboardingDate, String remarks, Date accoliteDoj, boolean onBench, Date benchStartDate, Date lwdInAccolite, int mentorshipRating, String mentorId, String projectType, String projectAllocationStatus, String currentLocation, boolean mentorship, String thLink, Date selectedDate, Date onboardingDate, String interviewIds) {
        this.empId = empId;
        this.name = name;
        this.skill = skill;
        this.pastExperience = pastExperience;
        this.baseLocation = baseLocation;
        this.status = status;
        this.clientId = clientId;
        this.tentativeOnboardingDate = tentativeOnboardingDate;
        this.remarks = remarks;
        this.accoliteDoj = accoliteDoj;
        this.onBench = onBench;
        this.benchStartDate = benchStartDate;
        this.lwdInAccolite = lwdInAccolite;
        this.mentorshipRating = mentorshipRating;
        this.mentorId = mentorId;
        this.projectType = projectType;
        this.projectAllocationStatus = projectAllocationStatus;
        this.currentLocation = currentLocation;
        this.mentorship = mentorship;
        this.thLink = thLink;
        this.selectedDate = selectedDate;
        this.onboardingDate = onboardingDate;
        this.interviewIds = interviewIds;
    }

    // Getters
    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    public int getPastExperience() {
        return pastExperience;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getStatus() {
        return status;
    }

    public String getClientId() {
        return clientId;
    }

    public Date getTentativeOnboardingDate() {
        return tentativeOnboardingDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public Date getAccoliteDoj() {
        return accoliteDoj;
    }

    public boolean isOnBench() {
        return onBench;
    }

    public Date getBenchStartDate() {
        return benchStartDate;
    }

    public Date getLwdInAccolite() {
        return lwdInAccolite;
    }

    public int getMentorshipRating() {
        return mentorshipRating;
    }

    public String getMentorId() {
        return mentorId;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getProjectAllocationStatus() {
        return projectAllocationStatus;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isMentorship() {
        return mentorship;
    }

    public String getThLink() {
        return thLink;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public Date getOnboardingDate() {
        return onboardingDate;
    }

    public String getInterviewIds() {
        return interviewIds;
    }

    // Setters
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setPastExperience(int pastExperience) {
        this.pastExperience = pastExperience;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setTentativeOnboardingDate(Date tentativeOnboardingDate) {
        this.tentativeOnboardingDate = tentativeOnboardingDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setAccoliteDoj(Date accoliteDoj) {
        this.accoliteDoj = accoliteDoj;
    }

    public void setOnBench(boolean onBench) {
        this.onBench = onBench;
    }

    public void setBenchStartDate(Date benchStartDate) {
        this.benchStartDate = benchStartDate;
    }

    public void setLwdInAccolite(Date lwdInAccolite) {
        this.lwdInAccolite = lwdInAccolite;
    }

    public void setMentorshipRating(int mentorshipRating) {
        this.mentorshipRating = mentorshipRating;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setProjectAllocationStatus(String projectAllocationStatus) {
        this.projectAllocationStatus = projectAllocationStatus;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setMentorship(boolean mentorship) {
        this.mentorship = mentorship;
    }

    public void setThLink(String thLink) {
        this.thLink = thLink;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public void setOnboardingDate(Date onboardingDate) {
        this.onboardingDate = onboardingDate;
    }

    public void setInterviewIds(String interviewIds) {
        this.interviewIds = interviewIds;
    }
}
