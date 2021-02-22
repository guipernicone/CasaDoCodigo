package com.zup.cqc.entity.book.response;

import com.zup.cqc.entity.author.response.AuthorDetailsWithoutEmail;
import com.zup.cqc.entity.book.Book;

import java.math.BigDecimal;

public class BookDetailsResponse {

    private String title;
    private String resume;
    private String sumary;
    private BigDecimal price;
    private int numberOfPages;
    private AuthorDetailsWithoutEmail authorDetails;

    public BookDetailsResponse(Book book){
        this.title = book.getTitle();
        this.resume = book.getResume();
        this.sumary = book.getSumary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.authorDetails = new AuthorDetailsWithoutEmail(book.getAuthor());
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

    public AuthorDetailsWithoutEmail getAuthorDetails() {
        return authorDetails;
    }
}
