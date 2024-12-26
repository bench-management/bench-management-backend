package BenchManagementTool.BMT.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "clients") // MongoDB collection name
public class Client {

    @Id
    private String clientId; // Unique identifier for each client (Primary Key)
    private String clientName; // Name of the client
    private String location; // Location of the client’s primary office or base
    private String BU; // The BU that will handle this client



    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBU() {
        return BU;
    }

    public void setBU(String BU) {
        this.BU = BU;
    }

}
