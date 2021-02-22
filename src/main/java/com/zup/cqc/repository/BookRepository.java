package com.zup.cqc.repository;

import com.zup.cqc.entity.book.Book;
import com.zup.cqc.entity.book.response.BookProjection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<BookProjection> findBookProjectionBy();
}
