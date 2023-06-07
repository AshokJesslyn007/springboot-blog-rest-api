package com.springboot.blog.controller;

import com.springboot.blog.request.PostDto;
import com.springboot.blog.response.PostResponse;
import com.springboot.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<PostResponse> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponse> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable long id) {
        return ResponseEntity.ok(postService.updatePost(postDto, id));
    }

    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable long id) {
        return postService.deletePostById(id);
    }
}
