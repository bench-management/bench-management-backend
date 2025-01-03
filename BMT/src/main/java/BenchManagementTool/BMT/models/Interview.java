package BenchManagementTool.BMT.models;

import BenchManagementTool.BMT.libs.Utils;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Data
@AllArgsConstructor
@Document(collection = "interviews")
public class Interview {

    @Id
    private String interviewId; // Unique identifier for the interview

    @NotBlank(message="Client id cannot be blank")
    private String clientId; // Client associated with the interview

    @NotNull(message = "interview status must be specified")
    private Utils.InterviewStatus interviewStatus; // Enum for the interview status

    @NotBlank(message = "Interviewer name cannot be blank")
    @NotNull(message = "interview name must be specified")
    private String interviewerName; // Name of the interviewer

    @NotBlank(message = "Project cannot be blank")
    private String project; // Associated project

    @NotBlank(message = "Client requirement cannot be blank")
    private String clientRequirement; // Client's requirement details

    @NotBlank(message = "Accolite hiring manager cannot be blank")
    private String accoliteHiringManager; // Accolite hiring manager

    @NotBlank(message = "Client hiring manager cannot be blank")
    private String clientHiringManager; // Client hiring manager

    @NotBlank(message = "Department cannot be blank")
    private String department; // Associated department

    @NotEmpty(message = "Comments cannot be empty")
    private List<String> comments; // List of comments for the interview

    private Candidate candidateId; // Full Candidate object stored internally

    private String candidateIdString; // Transient field for JSON input/output

}
