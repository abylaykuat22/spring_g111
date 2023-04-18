package kz.bitlab.springbootapp.controllers;

import java.util.List;
import kz.bitlab.springbootapp.models.Blog;
import kz.bitlab.springbootapp.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

  @Autowired
  private BlogService blogService;

  @GetMapping("/blogs")
  public String getBlogs(Model model) {
    List<Blog> blogs = blogService.getAllBlogs();
    model.addAttribute("novosti", blogs);
    return "blog";
  }

  @PostMapping("/addBlog")
  public String addBlog(@RequestParam String title,
      @RequestParam String description,
      @RequestParam String author) {
    blogService.addBlog(title, description, author);
    return "redirect:/blogs";
  }
}
