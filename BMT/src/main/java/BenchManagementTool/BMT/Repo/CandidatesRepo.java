package BenchManagementTool.BMT.Repo;

import BenchManagementTool.BMT.models.Candidates;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatesRepo extends MongoRepository<Candidates,String> {
}
