package com.youngadessi.app.post.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostCreateDTO {
//    private Long createUserId;
    private String title;
    private String content;
//    private List<CommentCreateDTO> commentsCreateDTO;
    private List<TagCreateDTO> tagsCreateDTO;
}
