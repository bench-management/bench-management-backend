package BenchManagementTool.BMT.models;

import BenchManagementTool.BMT.lib.Utils;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "candidates")
public class Candidate {
    @Id
    private String id;

    @DBRef
    private Client client;

    // TODO: link with mentorship table
    private String mentorship;

    private String empId;
    private String name;
    private String skill;
    private Integer pastExperience;

    private Utils.Location baseLocation;
    private Utils.Location currentLocation;
    private Utils.Status status;
    private Date accoliteDoj;
    private String thLink;  // Tech Hiring link

    private Date tentativeOnboardingDate;
    private String remarks;
    private boolean onBench;
    private Date benchStartDate;
    private Date lwdInAccolite;
    private String projectType;
    private String projectAllocationStatus;
    private Date selectionDate;
    private Date onboardingDate;

    private List<String> interviewIds;
}