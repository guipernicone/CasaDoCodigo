package com.zup.cqc.entity.book.response;

import com.zup.cqc.entity.author.Author;
import com.zup.cqc.entity.book.Book;
import com.zup.cqc.entity.category.Category;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponse {

    private long id;

    private String title;

    private String resume;

    private String sumary;

    private BigDecimal price;

    private int numberOfPages;

    private String lsbn;

    private LocalDate publishDate;

    private Category category;

    private Author author;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.resume = book.getResume();
        this.sumary = book.getSumary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.lsbn = book.getLsbn();
        this.publishDate = book.getPublishDate();
        this.category = book.getCategory();
        this.author = book.getAuthor();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSumary() {
        return sumary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getLsbn() {
        return lsbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
