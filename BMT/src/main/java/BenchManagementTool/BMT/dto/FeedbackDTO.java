package BenchManagementTool.BMT.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackDTO {
    private String id;

    @NotNull(message = "Mentor ID cannot be null")
    private int mentorId;

    @NotEmpty(message = "Mentor name cannot be empty")
    private String mentorName;

    @NotNull(message = "Candidate ID cannot be null")
    private int candidateId;

    @NotEmpty(message = "Candidate name cannot be empty")
    private String candidateName;

    @NotEmpty(message = "Comments cannot be empty")
    private String comments;

    @Min(1)
    @Max(5)
    private int rating;
}
