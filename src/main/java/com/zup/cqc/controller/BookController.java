package com.zup.cqc.controller;

import com.zup.cqc.entity.book.Book;
import com.zup.cqc.entity.book.form.CreateBookForm;
import com.zup.cqc.entity.book.response.BookDetailsResponse;
import com.zup.cqc.entity.book.response.BookProjection;
import com.zup.cqc.entity.book.response.BookResponse;
import com.zup.cqc.repository.BookRepository;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        BookResponse bookResponse = new BookResponse(book);
        return ResponseEntity.created(uri).body(bookResponse);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<BookProjection>> getBookList(){
        List<BookProjection> bookResponse = bookRepository.findBookProjectionBy();
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<BookDetailsResponse> getBook(@PathVariable(name = "id") long id){
        Optional<Book> bookOptional = bookRepository.findById(id);

        if(bookOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        BookDetailsResponse detailsResponse = new BookDetailsResponse(bookOptional.get());

        return ResponseEntity.ok(detailsResponse);
    }
}
