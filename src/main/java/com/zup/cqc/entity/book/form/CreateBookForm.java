package com.zup.cqc.entity.book.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.cqc.entity.author.Author;
import com.zup.cqc.entity.book.Book;
import com.zup.cqc.entity.category.Category;
import com.zup.cqc.entity.country.Country;
import com.zup.cqc.validator.UniqueValue;
import com.zup.cqc.validator.ValidId;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateBookForm {

    @NotBlank(message="{NotBlank}")
    @UniqueValue(fieldName = "title", domainClass = Book.class, message = "{UniqueValue}")
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
    @UniqueValue(fieldName = "lsbn", domainClass = Book.class, message = "{UniqueValue}")
    private String lsbn;

    @Future(message="{Future}")
    @NotNull(message="{NotNull}")
    @JsonFormat(pattern = "dd/MM/yyyy", shape= JsonFormat.Shape.STRING)
    private LocalDate publishDate;

    @NotNull(message="{NotNull}")
    @ValidId(domainClass = Category.class, message="{ValidId}")
    private long categoryId;

    @NotNull(message="{NotNull}")
    @ValidId(domainClass = Author.class, message="{ValidId}")
    private long authorId;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setLsbn(String lsbn) {
        this.lsbn = lsbn;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Book toModel(EntityManager entityManager) {
        Author author = entityManager.find(Author.class, this.authorId);
        Category category = entityManager.find(Category.class, this.categoryId);

        if ( author == null || category == null){
            throw new EntityNotFoundException("Entity not found");
        }
        return new Book(
                this.title,
                this.resume,
                this.sumary,
                this.price,
                this.numberOfPages,
                this.lsbn,
                this.publishDate,
                category,
                author
        );
    }
}
