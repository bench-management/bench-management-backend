package BenchManagementTool.BMT.services;
import BenchManagementTool.BMT.Repo.ClientRepo;
import BenchManagementTool.BMT.models.Candidate;
import BenchManagementTool.BMT.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepository;

    public List<Client> listAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
    }

    public Client getClientByCustomClientId(String clientId) {
        return clientRepository.findByClientId(clientId).orElseThrow(() -> new RuntimeException("Client not found with clientId: " + clientId));
    }

    // Delete client by clientId
    public void deleteClientByClientId(String clientId) {
        Client client = clientRepository.findByClientId(clientId).orElseThrow(() -> new RuntimeException("Client not found with clientId: " + clientId));
        clientRepository.delete(client);
    }

    // Update client by clientId
    public Client updateClientByClientId(String clientId, Client updatedClient) {
        Client existingClient = clientRepository.findByClientId(clientId).orElseThrow(() -> new RuntimeException("Client not found with clientId: " + clientId));

        if (updatedClient.getClientName() != null) {
            existingClient.setClientName(updatedClient.getClientName());
        }
        if (updatedClient.getLocation() != null) {
            existingClient.setLocation(updatedClient.getLocation());
        }
        if (updatedClient.getBusinessUnit() != null) {
            existingClient.setBusinessUnit(updatedClient.getBusinessUnit());
        }

        return clientRepository.save(existingClient);
    }

    public List<Client> searchClients(String searchTerm) {
        List<Client> clientById = clientRepository.findByClientIdStartingWithIgnoreCase(searchTerm);
        List<Client> clientByName = clientRepository.findByClientNameStartingWithIgnoreCase(searchTerm);
        clientByName.addAll(clientById);
        return clientByName;
    }
}
