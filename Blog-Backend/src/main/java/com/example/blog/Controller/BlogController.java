

package com.example.blog.Controller;

import com.example.blog.DTO.Api;
import com.example.blog.Model.Blog;
import com.example.blog.Repository.BlogRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BlogController {

    private final BlogRepository blogRepository;

    @GetMapping
    public ResponseEntity getBlogs() {

        return ResponseEntity.status(200).body(blogRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBlogsById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(blogRepository.findAll().get(id));
    }

    @PostMapping
    public ResponseEntity addBlogs(@RequestBody Blog blog) {
        blogRepository.save(blog);
        return ResponseEntity.status(201).body(new Api("New blog added !", 201));
    }
}