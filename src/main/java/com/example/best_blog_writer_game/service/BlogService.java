package com.example.best_blog_writer_game.service;

import com.example.best_blog_writer_game.model.BlogEntry;

public interface BlogService {
    void submitBlog(BlogEntry blogEntry);
    Iterable<BlogEntry> getAllBlogs();
    Iterable<BlogEntry> getTopBlogs();
}
