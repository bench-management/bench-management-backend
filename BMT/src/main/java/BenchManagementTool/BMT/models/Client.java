package BenchManagementTool.BMT.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "clients")
public class Client {
    @Id
    private String id;
    private String clientId;
    private String clientName;
    private String location;
    private String businessUnit;
}