package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.dto.ClientDTO;
import BenchManagementTool.BMT.models.Client;
import BenchManagementTool.BMT.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    public ClientDTO addClient(@Valid  @RequestBody ClientDTO dto) {
        return clientService.addClient(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable String id, @Valid @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientService.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}