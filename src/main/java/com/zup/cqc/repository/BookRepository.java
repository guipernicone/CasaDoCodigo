package com.zup.cqc.repository;

import com.zup.cqc.entity.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
