package BenchManagementTool.BMT.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "clients") // MongoDB collection name
public class Client {

    @Id
    private String clientId; // Unique identifier for each client (Primary Key)
    private String clientName; // Name of the client
    private String location; // Location of the client’s primary office or base
    private String BU; // The BU that will handle this client
}
