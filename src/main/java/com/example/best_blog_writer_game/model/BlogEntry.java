package com.example.best_blog_writer_game.model;

import jakarta.persistence.*;

@Entity
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;

    @Column(length = 500)
    private String text;

    private int referencesCount;

    public BlogEntry() {
    }

    public BlogEntry(String author, String title, String text, int referencesCount) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.referencesCount = referencesCount;
    }

    public BlogEntry(String author, String text, int referencesCount) {
        this.author = author;
        this.text = text;
        this.referencesCount = referencesCount;
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

    public int getReferencesCount() {
        return referencesCount;
    }

    public void setReferencesCount(int referencesCount) {
        this.referencesCount = referencesCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
