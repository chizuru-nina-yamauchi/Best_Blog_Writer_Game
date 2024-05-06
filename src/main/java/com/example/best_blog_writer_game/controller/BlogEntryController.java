package com.example.best_blog_writer_game.controller;

import com.example.best_blog_writer_game.model.BlogEntry;
import com.example.best_blog_writer_game.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogEntryController {

    @Autowired
    private BlogEntryService service;


    // Get mapping to show the home page
    @GetMapping("/")
    public String home(Model model){
        List<BlogEntry> entries = service.getAllBlogEntries();
        System.out.println(entries.size());
        model.addAttribute("entries", entries);
        return "home";
    }

    // Post mapping to submit a blog entry
    @PostMapping("/submit")
    public String submitBlogEntry(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("text") String text,
            Model model){
        try {
            service.saveBlogEntry(title, author, text);
            model.addAttribute("message", "Blog entry submitted successfully");
            } catch (IllegalArgumentException e){
            model.addAttribute("error", e.getMessage());
           e.printStackTrace();
        }
        return "submitResult";
    }


    // Get mapping to show the submit page
    @GetMapping("/submit")
    public String showSubmitForm(){
        return "submit";
    }

    // Get mapping to show the top blog entries
    @GetMapping("/results")
    public String showResults(Model model){
        List<BlogEntry> topEntries = service.getTopBlogEntries();
        model.addAttribute("topEntries", topEntries);
        return "results";
    }


}
