package kz.bitlab.springbootapp.services.impl;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.springbootapp.models.Blog;
import kz.bitlab.springbootapp.services.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

  List<Blog> blogs = new ArrayList<>();
  private Long id = 4L;

  {
    blogs.add(new Blog(1L, "Blog Title1", "Blog description 1", "blog author 1"));
    blogs.add(Blog.builder()
            .id(2L)
            .title("Blog Title2")
            .description("Blog description 1")
            .author("blog author 2")
        .build());
    blogs.add(new Blog(3L, "Blog Title3", "Blog description3", "blog author 3"));
  }

  @Override
  public List<Blog> getAllBlogs() {
    return blogs;
  }

  @Override
  public void addBlog(String title, String description, String author) {
    Blog blog = Blog.builder()
        .id(id)
        .title(title)
        .description(description)
        .author(author)
        .build();
    id++;
    blogs.add(blog);
  }
}
