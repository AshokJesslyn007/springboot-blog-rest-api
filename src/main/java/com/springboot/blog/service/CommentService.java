package com.springboot.blog.service;

import com.springboot.blog.request.CommentDto;
import com.springboot.blog.response.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse createComment(CommentDto commentDto, long postId);

    CommentResponse getCommentById(long postId, long commentId);

    List<CommentResponse> getAllComments(long postId);


}
