package com.springboot.blog.controller;

import com.springboot.blog.request.CommentDto;
import com.springboot.blog.response.CommentResponse;
import com.springboot.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{post-id}/comments")
    public ResponseEntity<CommentResponse> createComment(@Valid @PathVariable("post-id") long postId, @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(commentDto, postId), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{post-id}/comments")
    public ResponseEntity<List<CommentResponse>> getAllComments(@PathVariable("post-id") long postId) {
        return ResponseEntity.ok(commentService.getAllComments(postId));
    }

    @GetMapping("/posts/{post-id}/comments/{id}")
    public ResponseEntity<CommentResponse> getAllComments(@PathVariable("post-id") long postId, @PathVariable("id") long commentId) {
        return ResponseEntity.ok(commentService.getCommentById(postId, commentId));
    }
}

