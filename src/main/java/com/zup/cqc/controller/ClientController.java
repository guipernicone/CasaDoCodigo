package com.zup.cqc.controller;

import com.zup.cqc.entity.client.Client;
import com.zup.cqc.entity.client.form.CreateClientForm;
import com.zup.cqc.entity.client.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {
    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<ClientResponse> createClient(@RequestBody @Valid CreateClientForm clientForm, UriComponentsBuilder uriBuilder){
        Client client = clientForm.toModel(entityManager);
        entityManager.persist(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        ClientResponse clientResponse = new ClientResponse(client);
        return ResponseEntity.created(uri).body(clientResponse);

    }
}
