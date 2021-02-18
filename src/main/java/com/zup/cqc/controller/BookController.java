package com.zup.cqc.controller;

import com.zup.cqc.entity.book.Book;
import com.zup.cqc.entity.book.form.CreateBookForm;
import com.zup.cqc.entity.book.response.BookProjection;
import com.zup.cqc.entity.book.response.BookResponse;
import com.zup.cqc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<BookResponse> createBook (@RequestBody @Valid CreateBookForm bookForm, UriComponentsBuilder uriBuilder){
        Book book = bookForm.toModel(entityManager);
        entityManager.persist(book);

        URI uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book.buildResponse());
    }

    @GetMapping
    @Transactional()
    public ResponseEntity<List<BookProjection>> getBookList(){
        List<BookProjection> bookResponse = bookRepository.findBookProjectionBy();
        return ResponseEntity.ok(bookResponse);
    }
}
