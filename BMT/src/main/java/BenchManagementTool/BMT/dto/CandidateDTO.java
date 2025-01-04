package BenchManagementTool.BMT.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Builder;
import java.util.Date;

@Data
@Builder
public class CandidateDTO {
    private String id;

    @NotEmpty(message = "Employee ID cannot be empty")
    private String empId;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Skill cannot be empty")
    private String skill;

    @NotNull(message = "Past experience cannot be null")
    private Integer pastExperience;

    private String clientId;
    private Date tentativeOnboardingDate;
    private String remarks;
    private boolean onBench;
}
