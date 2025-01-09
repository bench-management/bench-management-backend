//package BenchManagementTool.BMT.models;
//
//import ch.qos.logback.core.joran.sanity.Pair;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.HashMap;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@Document(collection = "mentor")
//public class Mentor {
//    @Id
//    public int empId;
//    public String name;
//    public int rate;
//    public String comments;
//    public String candidateName;
//    public int candidateId;
//}
package BenchManagementTool.BMT.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "mentor")
public class Mentor{
    @Id
    private int id;
    private String name;
    private List<String> expertise;
    private int yoe; // Years of experience
}
