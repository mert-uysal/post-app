package com.youngadessi.app.post.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostUpdateDTO {
    private Long postId;
    private String title;
    private String content;
    private List<TagCreateModel> tagsUpdateDTO;
    private List<CommentCreateDTO> commentsUpdateDTO;
}
