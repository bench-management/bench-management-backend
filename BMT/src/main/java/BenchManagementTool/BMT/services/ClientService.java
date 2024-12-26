package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.ClientRepo;
import BenchManagementTool.BMT.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepository;

    public Client getClientById(String clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
    }


    public Client addClient(Client client) {
        return clientRepository.save(client);
    }


    public Client updateClient(String clientId, Client updatedClient) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
        client.setClientName(updatedClient.getClientName());
        client.setLocation(updatedClient.getLocation());
        client.setBU(updatedClient.getBU());
        return clientRepository.save(client);
    }


    public void deleteClient(String clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        } else {
            throw new RuntimeException("Client not found with ID: " + clientId);
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
