package com.example.best_blog_writer_game.repository;

import com.example.best_blog_writer_game.model.BlogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogEntryRepository extends JpaRepository<BlogEntry, Long> {
}
