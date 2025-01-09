package BenchManagementTool.BMT.Repo;

import BenchManagementTool.BMT.models.Mentor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MentorRepository extends MongoRepository<Mentor,Integer> {

}
