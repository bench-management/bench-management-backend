package BenchManagementTool.BMT.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
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
    private List<String> interviewIds; // foreign key for interviews conducted
}
