package com.youngadessi.app.post.service;

import com.youngadessi.app.post.model.dto.PostCreateDTO;
import com.youngadessi.app.post.model.dto.PostUpdateDTO;
import com.youngadessi.app.post.model.entity.Post;
import com.youngadessi.app.post.mappers.PostMapper;
import com.youngadessi.app.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private final PostMapper postMapper;

    public void createPost(PostCreateDTO postCreateDTO) {
        Post post = this.postMapper.postDtoToPostEntity(postCreateDTO);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String tempDate = formatter.format(date);
        post.setCreatedTime(LocalDateTime.parse(tempDate, formatter2));

        this.postRepository.save(post);
    }git

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
