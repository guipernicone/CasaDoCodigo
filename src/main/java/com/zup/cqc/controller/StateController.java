package com.zup.cqc.controller;

import com.zup.cqc.entity.state.form.CreateStateForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/state")
public class StateController {

    @PostMapping
    @Transactional
    public void createState(
            @RequestBody @Valid CreateStateForm createForm,
            UriComponentsBuilder uriBuilder){

    }
}
