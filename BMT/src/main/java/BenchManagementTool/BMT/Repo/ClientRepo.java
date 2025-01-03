package BenchManagementTool.BMT.Repo;


import BenchManagementTool.BMT.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends MongoRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
    List<Client> findByClientIdContainingIgnoreCase(String clientId);
}

