package BenchManagementTool.BMT.Repo;


import BenchManagementTool.BMT.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends MongoRepository<Client, String> {
}

