package com.example.best_blog_writer_game.controller;

import com.example.best_blog_writer_game.model.BlogEntry;
import com.example.best_blog_writer_game.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/submit")
    public String showBlogForm(Model model){
        model.addAttribute("blogEntry", new BlogEntry());
        return "blogForm";
    }

    @PostMapping("/submit")
    public String submitBlog(BlogEntry blogEntry){
        blogService.submitBlog(blogEntry);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs")
    public String showAllBlogs(Model model){
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "allBlogs";
    }

    @GetMapping("/top")
    public String showTopBlogs(Model model){
        model.addAttribute("topBlogs", blogService.getTopBlogs());
        return "topBlogs";
    }


}
