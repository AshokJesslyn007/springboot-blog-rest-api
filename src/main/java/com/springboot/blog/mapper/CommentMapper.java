package com.springboot.blog.mapper;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.request.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    Comment mapToCommentEntity(CommentDto commentDto);

    List<Comment> mapToComments(List<CommentDto> commentDtos);

    CommentDto mapToCommentDto(Comment comment);


}
