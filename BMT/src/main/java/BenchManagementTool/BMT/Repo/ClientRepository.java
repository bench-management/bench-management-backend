package BenchManagementTool.BMT.Repo;


import BenchManagementTool.BMT.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
    List<Client> findByClientIdStartingWithIgnoreCase(String clientId);
    List<Client> findByClientNameStartingWithIgnoreCase(String searchTerm);
}

