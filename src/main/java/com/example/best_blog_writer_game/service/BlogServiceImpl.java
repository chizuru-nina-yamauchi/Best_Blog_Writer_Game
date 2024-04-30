package com.example.best_blog_writer_game.service;

import com.example.best_blog_writer_game.model.BlogEntry;
import com.example.best_blog_writer_game.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogEntryRepository blogEntryRepository;

    @Override
    public void submitBlog(BlogEntry blogEntry) {
        if (isValidBlog(blogEntry)) {
            blogEntryRepository.save(blogEntry);
        }else {
            throw new IllegalArgumentException("Invalid blog entry");
        }
    }

    @Override
    public Iterable<BlogEntry> getAllBlogs() {
        return blogEntryRepository.findAll();
    }

    @Override
    public Iterable<BlogEntry> getTopBlogs() {
        return getAllBlogs();  // TODO: Implement this method  :blogEntryRepository.findTop3ByOrderByReferenceCountDesc();
    }

    private boolean isValidBlog(BlogEntry blogEntry) {

        String text = blogEntry.getText();
        return text.contains(blogEntry.getTitle()) && countReferences(text) >= 3;
    }

    private int countReferences(String text){
        int count = 0;
        int index = text.indexOf("[REF]");
        while (index != -1) {
            count++;
            index = text.indexOf("[REF]", index + 1);
        }
        return count;
    }
}
