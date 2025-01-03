package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.models.Client;
import BenchManagementTool.BMT.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.listAllClients();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/id/{id}")
    public Client getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/clientId/{clientId}")
    public Client getClientByClientId(@PathVariable String clientId) {
        return clientService.getClientByCustomClientId(clientId);
    }

    // Delete client by custom clientId
    @DeleteMapping("/clientId/{clientId}")
    public void deleteClientByClientId(@PathVariable String clientId) {
        clientService.deleteClientByClientId(clientId);
    }

    // Update client by custom clientId
    @PutMapping("/clientId/{clientId}")
    public Client updateClientByClientId(@PathVariable String clientId, @RequestBody Client client) {
        return clientService.updateClientByClientId(clientId, client);
    }

    @GetMapping("/search")
    public List<Client> searchClients(@RequestParam String searchTerm) {
        return clientService.searchClients(searchTerm);
    }
}
