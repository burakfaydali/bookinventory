package com.bfaydali.bookinventory.model.entity;

import com.bfaydali.bookinventory.model.response.BookResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import com.bfaydali.bookinventory.model.enums.BookCategory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Max(5000)
    @Column(name = "page_count")
    private int pageCount;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "book_categories", joinColumns = @JoinColumn(name = "book_id"))
    private Set<BookCategory> categories = new HashSet<>();

    public Book() {
    }

    public Book(String name, Author author, int pageCount, Set<BookCategory> categories) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.categories = categories;
    }

    public BookResponse toResponse() {
        return new BookResponse(
                id,
                name,
                author.toResponse(),
                pageCount,
                categories
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Set<BookCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<BookCategory> categories) {
        this.categories = categories;
    }
} 