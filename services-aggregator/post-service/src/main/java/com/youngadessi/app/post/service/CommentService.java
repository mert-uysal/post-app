package com.youngadessi.app.post.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.youngadessi.app.post.mappers.CommentMapper;
import com.youngadessi.app.post.model.dto.CommentCreateDTO;
import com.youngadessi.app.post.model.entity.Comment;
import com.youngadessi.app.post.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    public void createComment(CommentCreateDTO commentCreateDTO) {
        Comment comment = commentMapper.commentCreateDTOTOComment(commentCreateDTO);
        commentRepository.save(comment);
    }
}
