package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.ClientDTO;
import BenchManagementTool.BMT.models.Client;
import BenchManagementTool.BMT.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO dto) {
        return clientService.addClient(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}