package BenchManagementTool.BMT.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "feedback")
public class Feedback {
    @Id
    private String id;

    @DBRef // Reference to Mentor table
    Mentor mentor;

    private int candidateId;
    private String candidateName;
    private String comments;
    private int rating; // e.g., 1-5 scale
}