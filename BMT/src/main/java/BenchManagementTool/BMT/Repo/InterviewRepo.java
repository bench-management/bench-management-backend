package BenchManagementTool.BMT.Repo;

import BenchManagementTool.BMT.models.Interview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepo extends MongoRepository<Interview, String> {

    List<Interview> findByEmployeeId(String employeeId);

    List<Interview> findByClientId(String clientId);
}
