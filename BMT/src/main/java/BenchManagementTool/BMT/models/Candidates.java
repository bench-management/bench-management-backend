package BenchManagementTool.BMT.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Document(collection = "Candidates")
public class Candidates {

    @Id
    private String id;
    private String name;
    private String skill;
    private int pastExperience; // Experience in years before joining the company
    private String baseLocation;
    private String status; // e.g., Active, On Bench, Allocated
    private String clientId; // If allocated
    private LocalDate tentativeOnboardingDate;
    private String remarks;
    private LocalDate accoliteDoj;
    private boolean onBench; // Yes/No
    private LocalDate benchStartDate;
    private LocalDate lwdInAccolite; // Last Working Date
    private int mentorshipRating;
    private String mentorId; // if mentorship
    private String projectType;
    private String projectAllocationStatus;
    private String currentLocation;
    private boolean mentorship; // Yes/No
    private String thLink; // Tech Hiring link
    private LocalDate selectedDate;
    private LocalDate onboardingDate;
    private List<String> interviewIds;



    public Candidates(String id, String name, String skill, int pastExperience, String baseLocation, String status, String clientId, LocalDate tentativeOnboardingDate, String remarks, LocalDate accoliteDoj, boolean onBench, LocalDate benchStartDate, LocalDate lwdInAccolite, int mentorshipRating, String mentorId, String projectType, String projectAllocationStatus, String currentLocation, boolean mentorship, String thLink, LocalDate selectedDate, LocalDate onboardingDate, List<String> interviewIds) {
        this.id = id;
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

}
