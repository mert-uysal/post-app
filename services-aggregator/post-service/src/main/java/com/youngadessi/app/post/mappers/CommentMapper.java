package com.youngadessi.app.post.mappers;

import org.mapstruct.Mapper;

import com.youngadessi.app.post.model.dto.CommentCreateDTO;
import com.youngadessi.app.post.model.entity.Comment;

@Mapper
public interface CommentMapper {
    Comment commentCreateDTOTOComment(CommentCreateDTO commentCreateDTO);
}
