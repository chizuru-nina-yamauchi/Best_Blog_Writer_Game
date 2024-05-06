package com.example.best_blog_writer_game.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blog_entries")
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String text;

    public BlogEntry() {
    }

    public BlogEntry(String author, String title, String text) {
        this.author = author;
        this.title = title;
        this.text = text;
    }

    public BlogEntry(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
