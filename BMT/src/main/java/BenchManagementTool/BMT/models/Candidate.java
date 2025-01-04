package BenchManagementTool.BMT.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "candidates")
public class Candidate {
    @Id
    private String id;
    private String empId;
    private String name;
    private String skill;
    private Integer pastExperience;

    @DBRef
    private Client client;
    private Date tentativeOnboardingDate;
    private String remarks;
    private boolean onBench;
}