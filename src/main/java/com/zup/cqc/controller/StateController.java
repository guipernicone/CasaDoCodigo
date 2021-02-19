package com.zup.cqc.controller;

import com.zup.cqc.entity.state.State;
import com.zup.cqc.entity.state.form.CreateStateForm;
import com.zup.cqc.entity.state.response.StateResponse;
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
@RequestMapping("/state")
public class StateController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<StateResponse> createState(
            @RequestBody @Valid CreateStateForm createForm,
            UriComponentsBuilder uriBuilder){

        State state = createForm.toModel(entityManager);
        entityManager.persist(state);

        URI uri = uriBuilder.path("/state/{id}").buildAndExpand(state.getId()).toUri();
        StateResponse stateResponse = new StateResponse(state);

        return ResponseEntity.created(uri).body(stateResponse);

    }
}
