package BenchManagementTool.BMT.models;

import BenchManagementTool.BMT.lib.Utils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "candidates")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candidate {

    @Id
    private String id;

    private String client;

    // TODO: link with mentorship table
    private String mentorship;

    private String empId;
    private String name;
    private String candidateName;
    private String skill;
    private Integer pastExperience;
    private float experience;
    private String level;



    private Utils.Location baseLocation;
    private Utils.Location currentLocation;
    private Utils.Status status;
    private LocalDate accoliteDoj;
    private String thLink;  // Tech Hiring link

    private LocalDate tentativeOnboardingDate;
    private List<String> remarks;
    private boolean onBench;
    private LocalDate benchStartDate;
    private LocalDate lwdInAccolite;
    private String projectType;
    private String projectAllocationStatus;
    private LocalDate selectionDate;
    private LocalDate onboardingDate; //joining date

    private List<String> interviewIds;
}