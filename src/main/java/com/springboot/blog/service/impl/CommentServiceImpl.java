package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exceptions.ResourceNotFoundException;
import com.springboot.blog.repository.CommentRespository;
import com.springboot.blog.repository.PostRespository;
import com.springboot.blog.request.CommentDto;
import com.springboot.blog.response.CommentResponse;
import com.springboot.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRespository postRespository;
    private CommentRespository commentRespository;

    public CommentServiceImpl(PostRespository postRespository, CommentRespository commentRespository) {
        this.postRespository = postRespository;
        this.commentRespository = commentRespository;
    }

    @Override
    public CommentResponse createComment(CommentDto commentDto, long postId) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmailId(commentDto.getEmailId());
        comment.setBody(commentDto.getBody());

        Post post = postRespository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        comment.setPost(post);

        Comment savedComment = commentRespository.save(comment);

        return CommentResponse.builder()
                .id(savedComment.getId())
                .name(savedComment.getName())
                .emailId(savedComment.getEmailId())
                .body(savedComment.getBody())
                .build();
    }

    @Override
    public CommentResponse getCommentById(long postId, long commentId) {
        Post post = postRespository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = commentRespository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new ResourceNotFoundException("comment", "id", commentId);
        }
        return CommentResponse.builder()
                .id(comment.getId())
                .name(comment.getName())
                .emailId(comment.getEmailId())
                .body(comment.getBody())
                .build();

    }

    @Override
    public List<CommentResponse> getAllComments(long postId) {
        Post post = postRespository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return post.getComments().stream().map(comment -> CommentResponse.builder()
                .id(comment.getId())
                .name(comment.getName())
                .emailId(comment.getEmailId())
                .body(comment.getBody())
                .build()).toList();
    }
}
