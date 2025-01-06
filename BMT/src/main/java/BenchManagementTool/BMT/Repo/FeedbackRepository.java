package BenchManagementTool.BMT.Repo;

import BenchManagementTool.BMT.models.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback,Integer> {
    List<Feedback> findByMentorId(String mentorId); // Query feedback by mentorId
    List<Feedback> findByCandidateId(int candidateId); // Query feedback by candidateId

}
