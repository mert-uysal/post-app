package com.youngadessi.app.post.mappers;

import com.youngadessi.app.post.model.dto.CommentCreateDTO;
import com.youngadessi.app.post.model.dto.PostCreateDTO;
import com.youngadessi.app.post.model.dto.PostUpdateDTO;
import com.youngadessi.app.post.model.dto.TagCreateDTO;
import com.youngadessi.app.post.model.entity.Comment;
import com.youngadessi.app.post.model.entity.Post;
import com.youngadessi.app.post.model.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mappings({
            @Mapping(target = "tags", source = "postCreateDTO.tagsCreateDTO"),
            @Mapping(ignore = true, target = "comments")
    })
    Post postDtoToPostEntity(PostCreateDTO postCreateDTO);

    @Mappings({
            @Mapping(target = "tags", source = "postUpdateDTO.tagsUpdateDTO"),
            @Mapping(target = "comments", source = "postUpdateDTO.commentsUpdateDTO")
    })
    Post postUpdateDtoToPostEntity(PostUpdateDTO postUpdateDTO);

//    @Mapping(target = "tagName", source = "tagCreateDTO.tagName")
//    Tag tagDtoToTagEntity(TagCreateDTO tagCreateDTO);
//
//    @Mappings({
//            @Mapping(target = "commentText", source = "commentCreateDTO.commentText"),
//            @Mapping(target = "post", source = "commentCreateDTO.postCreateDTO")
//    })
//    Comment commentDtoToCommentEntity(CommentCreateDTO commentCreateDTO);
}
