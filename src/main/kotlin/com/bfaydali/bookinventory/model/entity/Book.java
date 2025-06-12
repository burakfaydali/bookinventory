package com.bfaydali.bookinventory.model.entity;

import com.bfaydali.bookinventory.model.response.BookResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String author;

    @Max(5000)
    @Column(name = "page_count")
    private int pageCount;

    public Book() {
    }

    public Book(String name, String author, int pageCount) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }

    public BookResponse toBookResponse() {
        return new BookResponse(
                id,
                name,
                author,
                pageCount
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
} 