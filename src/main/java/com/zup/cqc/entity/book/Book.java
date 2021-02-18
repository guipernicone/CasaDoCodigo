package com.zup.cqc.entity.book;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.cqc.entity.author.Author;
import com.zup.cqc.entity.book.response.BookResponse;
import com.zup.cqc.entity.category.Category;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message="{NotBlank}")
    private String title;

    @NotBlank(message="{NotBlank}")
    @Size(max= 500, message="{Size.resume}")
    private String resume;

    @NotBlank(message="{NotBlank}")
    private String sumary;

    @NotNull(message="{NotNull}")
    @Min(value=20, message="{Min.price}")
    private BigDecimal price;

    @NotNull(message="{NotNull}")
    @Min(value=100, message="{Min.numberOfPages}")
    private int numberOfPages;

    @NotBlank(message="{NotBlank}")
    private String lsbn;

    @Future(message="{Future}")
    @NotNull(message="{NotNull}")
    private LocalDate publishDate;

    @NotNull(message="{NotNull}")
    @ManyToOne
    private Category category;

    @NotNull(message="{NotNull}")
    @ManyToOne
    private Author author;

    public Book(String title,
                String resume,
                String sumary,
                BigDecimal price,
                int numberOfPages,
                String lsbn,
                LocalDate publishDate,
                Category category,
                Author author) {
        this.title = title;
        this.resume = resume;
        this.sumary = sumary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.lsbn = lsbn;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public BookResponse buildResponse() {
        return new BookResponse(
                this.id,
                this.title,
                this.resume,
                this.sumary,
                this.price,
                this.numberOfPages,
                this.lsbn,
                this.publishDate,
                this.category,
                this.author
        );
    }
}
