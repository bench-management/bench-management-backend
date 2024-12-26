package BenchManagementTool.BMT.Repo;

import BenchManagementTool.BMT.models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatesRepo extends MongoRepository<Candidate, String> {
    Optional<Candidate> findByEmpId(String empId);
}
