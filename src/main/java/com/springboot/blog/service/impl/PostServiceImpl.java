package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Post;
import com.springboot.blog.exceptions.ResourceNotFoundException;
import com.springboot.blog.mapper.PostMapper;
import com.springboot.blog.repository.PostRespository;
import com.springboot.blog.request.PostDto;
import com.springboot.blog.response.PostResponse;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRespository postRespository;

    public PostServiceImpl(PostRespository postRespository) {
        this.postRespository = postRespository;
    }

    @Override
    public PostResponse createPost(PostDto postDto) {
        Post postSavedEntity = postRespository.save(PostMapper.postMapper.mapToPostEntity(postDto));
        return PostMapper.postMapper.mapToPostResponse(postSavedEntity);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> postEntitys = postRespository.findAll();
        return PostMapper.postMapper.mapToPostResponseList(postEntitys);
    }

    @Override
    public PostResponse getPostById(long id) {
        Post postEntity = postRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        return PostMapper.postMapper.mapToPostResponse(postEntity);
    }

    @Override
    public PostResponse updatePost(PostDto postDto, long id) {
        Post postEntity = postRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        postEntity.setTitle(postDto.getTitle());
        postEntity.setDescription(postDto.getDescription());
        postEntity.setContent(postDto.getContent());
        Post postSavedEntity = postRespository.save(postEntity);
        return PostMapper.postMapper.mapToPostResponse(postSavedEntity);
    }

    @Override
    public String deletePostById(long id) {
        Post postEntity = postRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        postRespository.deleteById(postEntity.getId());
        return "Post deleted successfully !!";
    }
}
