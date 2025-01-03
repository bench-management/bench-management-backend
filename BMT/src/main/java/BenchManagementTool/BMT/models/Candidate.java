package BenchManagementTool.BMT.models;

import BenchManagementTool.BMT.libs.Utils;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "candidates")
public class Candidate {

    @Id
    private String id;

    @NotEmpty(message = "Employee ID cannot be empty")
    private String empId;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Skill cannot be empty")
    private Utils.Skill skill;

    @NotNull(message = "Past experience cannot be null")
    private Integer pastExperience;

    @NotEmpty(message = "Base location cannot be empty")
    private Utils.Location baseLocation;

    @NotEmpty(message = "Status cannot be empty")
    private Utils.Status status;

    @NotNull(message = "Accolite DOJ cannot be null")
    private Date accoliteDoj;

    private Boolean onBench;
    private String clientId; // If allocated
    private Date tentativeOnboardingDate;
    private String remarks;
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
