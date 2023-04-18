package kz.bitlab.springbootapp.services;

import java.util.List;
import kz.bitlab.springbootapp.models.Blog;

public interface BlogService {

  List<Blog> getAllBlogs();

  void addBlog(String title, String description, String author);
}
