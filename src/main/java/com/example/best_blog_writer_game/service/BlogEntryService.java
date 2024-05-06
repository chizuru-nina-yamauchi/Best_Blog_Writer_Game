package com.example.best_blog_writer_game.service;

import com.example.best_blog_writer_game.model.BlogEntry;
import com.example.best_blog_writer_game.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BlogEntryService {

    @Autowired
    private BlogEntryRepository repository;

    // save blog entry
    public BlogEntry saveBlogEntry(String title, String author, String text) throws IllegalArgumentException{
        if(!(text.length() >500 && text.length() < 600)) throw new IllegalArgumentException("Text length must be between 500 and 600");
        if(!text.contains(title)) throw new IllegalArgumentException("Blog Entry text must include the title");
        // check the number of references:minimum 3
        if(countReferences(text) < 3) throw new IllegalArgumentException("Blog Entry text must include at least 3 references");
        return repository.save(new BlogEntry(title, author, text));
    }

    // get all blog entries
    public List<BlogEntry> getAllBlogEntries(){
        return repository.findAll();
    }

    //get top blog entry
    public List<BlogEntry> getTopBlogEntries(){
        List<BlogEntry> entries = repository.findAll();
        Stream<BlogEntry> entriesStream = entries.stream();
        List<BlogEntry> topEntries = entriesStream
                .sorted((e1, e2) -> Integer.compare(countReferences(e1.getText()), countReferences(e2.getText())))
                .collect(Collectors.toList());
        List<BlogEntry> topThree = new ArrayList<>();
        if(topEntries.size()>=3) topThree = topEntries.subList(0, 3);
        else topThree = topEntries;
     return topThree;
    }

    private int countReferences(String text){
        if(text.contains("ref:"))
        return text.split("ref:").length-1;
        else return 0;
    }
}
