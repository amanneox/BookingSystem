package com.api.api.controller;

import com.api.api.exception.ResourceNotFoundException;
import com.api.api.model.ClientModel;
import com.api.api.model.UserModel;
import com.api.api.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

    @Autowired
    private ClientRepo clientRepo;

    @GetMapping("/client")
    public Page<ClientModel> getClients(Pageable pageable) {
        return clientRepo.findAll(pageable);
    }


    @GetMapping("/client/{clientId}")
    public Optional<ClientModel> getClientById(@PathVariable Long clientId) {
        return clientRepo.findById(clientId);

    }

    @PostMapping("/client")
    public ClientModel createClient(@Valid @RequestBody ClientModel client) {
        return clientRepo.save(client);
    }

    @PostMapping("/client/update/{clientId}")
    public ClientModel updateClient(@PathVariable Long clientId,
                                @Valid @RequestBody ClientModel clientRequest) {
        return clientRepo.findById(clientId)
                .map(client -> {


                    client.setBookingID(clientRequest.getBookingID());

                    return clientRepo.save(client);
                }).orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
    }


    @PostMapping("/client/delete/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientRepo.findById(clientId)
                .map(client -> {
                    clientRepo.delete(client);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
    }
}
