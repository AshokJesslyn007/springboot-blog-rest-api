package com.springboot.blog.mapper;

import com.springboot.blog.entity.Post;
import com.springboot.blog.request.PostDto;
import com.springboot.blog.response.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {
    PostMapper postMapper = Mappers.getMapper(PostMapper.class);

    Post mapToPostEntity(PostDto postDto);

    PostResponse mapToPostResponse(Post post);

    List<PostResponse> mapToPostResponseList(List<Post> post);
}
