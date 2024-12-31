package BenchManagementTool.BMT.Repo;

import BenchManagementTool.BMT.models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatesRepo extends MongoRepository<Candidate, String> {
    Optional<Candidate> findByEmpId(String empId);
    void deleteByEmpId(String empId);

    List<Candidate> findByEmpIdStartingWithIgnoreCase(String searchTerm);

    List<Candidate> findByNameStartingWithIgnoreCase(String searchTerm);
}
