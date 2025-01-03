package BenchManagementTool.BMT.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "clients")
public class Client {

    @Id
    private String id; // MongoDB's default `_id`

    private String clientId; // Unique identifier for each client
    private String clientName; // Name of the client
    private String location; // Location of the client’s primary office
    private String businessUnit; // The business unit (BU)
}
