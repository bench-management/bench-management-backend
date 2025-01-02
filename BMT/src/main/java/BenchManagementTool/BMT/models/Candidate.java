package BenchManagementTool.BMT.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
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
}
