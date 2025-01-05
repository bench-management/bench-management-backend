package BenchManagementTool.BMT.dto;

import BenchManagementTool.BMT.lib.Utils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class InterviewDTO {
    private String id;

    @NotNull(message = "Client ID cannot be null")
    private String clientId;

    @NotNull(message = "Candidate ID cannot be null")
    private String candidateId;

    @NotEmpty(message = "Interviewer name cannot be empty")
    private String interviewerName;

    @NotNull(message = "Interview Status cannot be null")
    private Utils.InterviewStatus interviewStatus;

    @NotNull(message = "Interview Date cannot be null")
    private Date interviewDate;

    private String project;
    private String clientRequirement;
    private String accoliteHiringManager;
    private String clientHiringManager;
    private String department;
    private List<String> comments;
}