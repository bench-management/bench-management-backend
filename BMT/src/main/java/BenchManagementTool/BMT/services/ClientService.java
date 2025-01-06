package BenchManagementTool.BMT.services;
import BenchManagementTool.BMT.Repo.ClientRepository;
import BenchManagementTool.BMT.dto.ClientDTO;
import BenchManagementTool.BMT.mappers.EntityMapper;
import BenchManagementTool.BMT.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(EntityMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(String id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(EntityMapper::toClientDTO).orElse(null);
    }

    public ClientDTO addClient(ClientDTO dto) {
        Client client = EntityMapper.toClient(dto);
        return EntityMapper.toClientDTO(clientRepository.save(client));
    }

    public ClientDTO updateClient(String id, ClientDTO dto) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Client updatedClient = EntityMapper.toClient(dto);
        updatedClient.setId(existingClient.getId());

        return EntityMapper.toClientDTO(clientRepository.save(updatedClient));
    }

    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }

    public List<ClientDTO> searchClients(String searchTerm) {
        List<Client> clients;

        if (searchTerm == null || searchTerm.isEmpty()) {
            // If searchTerm is empty or null, return all clients
            clients = clientRepository.findAll();
        } else {
            // Perform the search based on the provided searchTerm
            List<Client> clientsByName = clientRepository.findByClientNameStartingWithIgnoreCase(searchTerm);
            List<Client> clientsByClientId = clientRepository.findByClientIdStartingWithIgnoreCase(searchTerm);

            // Combine results, ensuring no duplicates
            clientsByName.addAll(clientsByClientId);

            // Remove duplicates (if any)
            clients = clientsByName.stream().distinct().toList();
        }

        // Map to ClientDTO
        return clients.stream()
                .map(EntityMapper::toClientDTO)
                .collect(Collectors.toList());
    }

}