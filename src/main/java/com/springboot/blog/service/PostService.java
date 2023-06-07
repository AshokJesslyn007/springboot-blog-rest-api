package com.springboot.blog.service;

import com.springboot.blog.request.PostDto;
import com.springboot.blog.response.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse createPost(PostDto postDto);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(long id);

    PostResponse updatePost(PostDto postDto, long id);

    String deletePostById(long id);

}
