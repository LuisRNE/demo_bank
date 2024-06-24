package com.lrne.bank.demo.controller;

import com.lrne.bank.demo.entity.Client;
import com.lrne.bank.demo.exception.ResourceNotFoundException;
import com.lrne.bank.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo_bank")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @GetMapping
    public List<Client> getAllClients(){
    return bankRepository.findAll();
    }
    @PostMapping
    public Client createClient(@RequestBody Client client){
        return bankRepository.save(client);
    }
    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client clientDetail){
        Client updateClient = bankRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Client not exist with email:" + id));
    updateClient.setBankName(clientDetail.getBankName());
    updateClient.setBankBranch(clientDetail.getBankBranch());
    updateClient.setAccHolderName(clientDetail.getAccHolderName());
    updateClient.setAccNumber(clientDetail.getAccNumber());
    updateClient.setAccMobileNumber(clientDetail.getAccMobileNumber());

    bankRepository.save(updateClient);

    return ResponseEntity.ok(updateClient);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id){
    Client client = bankRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Client not exist with email: " + id));
    return ResponseEntity.ok(client);
    }

}
