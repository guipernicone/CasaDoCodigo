package com.zup.cqc.controller;

import com.zup.cqc.entity.author.Author;
import com.zup.cqc.entity.author.form.CreateAuthorForm;
import com.zup.cqc.entity.author.response.AuthorResponse;
import com.zup.cqc.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody @Valid CreateAuthorForm authorForm, UriComponentsBuilder uriBuilder) {
        Author author = authorForm.toModel();
        authorRepository.save(author);

        URI uri = uriBuilder.path("/author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author.buildResponse());
    }

}
