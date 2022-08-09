package com.youngadessi.app.post.mappers;

import com.youngadessi.app.post.model.dto.PostCreateDTO;
import com.youngadessi.app.post.model.dto.PostUpdateDTO;
import com.youngadessi.app.post.model.entity.Post;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {

    Post postCreateDTOTOPost(PostCreateDTO postCreateDTO);

    Post postUpdateDtoToPostEntity(PostUpdateDTO postUpdateDTO);
}
