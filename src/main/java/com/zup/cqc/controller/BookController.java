package com.zup.cqc.controller;

import com.zup.cqc.entity.book.Book;
import com.zup.cqc.entity.book.form.CreateBookForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Book> createBook (@RequestBody @Valid CreateBookForm bookForm, UriComponentsBuilder uriBuilder){
        Book book = bookForm.toModel(entityManager);
        entityManager.persist(book);

        URI uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book);
    }
}
