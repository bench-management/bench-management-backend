package BenchManagementTool.BMT.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Builder;
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

    private String project;
    private String clientRequirement;
    private String accoliteHiringManager;
    private String clientHiringManager;
    private String department;
    private List<String> comments;
}