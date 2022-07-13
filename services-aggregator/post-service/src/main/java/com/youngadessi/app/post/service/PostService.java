package com.youngadessi.app.post.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.youngadessi.app.post.mappers.PostMapper;
import com.youngadessi.app.post.model.dto.PostCreateDTO;
import com.youngadessi.app.post.model.dto.PostUpdateDTO;
import com.youngadessi.app.post.model.entity.Post;
import com.youngadessi.app.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper= Mappers.getMapper(PostMapper.class);

    public void createPost(PostCreateDTO postCreateDTO) {
        Post post=postMapper.postCreateDTOTOPost(postCreateDTO);
        LocalDateTime today = LocalDateTime.now();
        post.setCreatedTime(today.truncatedTo(ChronoUnit.SECONDS));
        this.postRepository.save(post);
    }



    public void updatePost(PostUpdateDTO postUpdateDTO) {
        Optional<Post> optionalPost = this.postRepository.findById(postUpdateDTO.getPostId());

        optionalPost.orElseThrow(
            () -> new RuntimeException("Post object with id " + postUpdateDTO.getPostId() + " not found on database"));
        Post post;
        post = this.postMapper.postUpdateDtoToPostEntity(postUpdateDTO);
        this.postRepository.save(post);
    }

    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }
}
