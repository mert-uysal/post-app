package com.youngadessi.app.post.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateDTO {
    private String commentText;
    private PostCreateDTO postCreateDTO;
}
