package BenchManagementTool.BMT.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "candidates")
public class Candidate {

    @Id
    private String id;

    @NotEmpty(message = "Employee ID cannot be empty")
    private String empId;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Skill cannot be empty")
    private String skill;

    @NotNull(message = "Past experience cannot be null")
    private Integer pastExperience;

    @NotEmpty(message = "Base location cannot be empty")
    private String baseLocation;

    @NotEmpty(message = "Status cannot be empty")
    private String status;

    @NotNull(message = "Accolite DOJ cannot be null")
    private Date accoliteDoj;

    @NotNull(message = "OnBench cannot be null")
    private Boolean onBench;

    // Optional fields
    private Date tentativeOnboardingDate;
    private String clientId;
    private String remarks;
    private Date benchStartDate;
    private Date lwdInAccolite;
    private Integer mentorshipRating;
    private String mentorId;
    private String projectType;
    private String projectAllocationStatus;
    private String currentLocation;
    private Boolean mentorship;
    private String thLink;
    private Date selectedDate;
    private Date onboardingDate;
    private String interviewIds;

    public Candidate() {}

    public Candidate(String empId, String name, String skill, Integer pastExperience, String baseLocation, String status, String clientId, Date tentativeOnboardingDate, String remarks, Date accoliteDoj, Boolean onBench, Date benchStartDate, Date lwdInAccolite, Integer mentorshipRating, String mentorId, String projectType, String projectAllocationStatus, String currentLocation, Boolean mentorship, String thLink, Date selectedDate, Date onboardingDate, String interviewIds) {
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

    public Integer getPastExperience() {
        return pastExperience;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getOnBench() {
        return onBench;
    }

    public Date getAccoliteDoj() {
        return accoliteDoj;
    }

    public Date getTentativeOnboardingDate() {
        return tentativeOnboardingDate;
    }

    public String getClientId() {
        return clientId;
    }

    public String getRemarks() {
        return remarks;
    }

    public Date getBenchStartDate() {
        return benchStartDate;
    }

    public Date getLwdInAccolite() {
        return lwdInAccolite;
    }

    public Integer getMentorshipRating() {
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

    public Boolean getMentorship() {
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

    public void setPastExperience(Integer pastExperience) {
        this.pastExperience = pastExperience;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOnBench(Boolean onBench) {
        this.onBench = onBench;
    }

    public void setAccoliteDoj(Date accoliteDoj) {
        this.accoliteDoj = accoliteDoj;
    }

    public void setTentativeOnboardingDate(Date tentativeOnboardingDate) {
        this.tentativeOnboardingDate = tentativeOnboardingDate;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setBenchStartDate(Date benchStartDate) {
        this.benchStartDate = benchStartDate;
    }

    public void setLwdInAccolite(Date lwdInAccolite) {
        this.lwdInAccolite = lwdInAccolite;
    }

    public void setMentorshipRating(Integer mentorshipRating) {
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

    public void setMentorship(Boolean mentorship) {
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
