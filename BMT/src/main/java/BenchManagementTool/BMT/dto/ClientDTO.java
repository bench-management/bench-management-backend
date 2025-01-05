package BenchManagementTool.BMT.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ClientDTO {
    private String id;
    private String clientId;
    private String clientName;
    private String location;
    private String businessUnit;
}
