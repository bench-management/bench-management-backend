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

    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }
}