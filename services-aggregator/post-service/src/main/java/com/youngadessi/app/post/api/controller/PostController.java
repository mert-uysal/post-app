package com.youngadessi.app.post.api.controller;

import com.youngadessi.app.post.model.dto.PostCreateDTO;
import com.youngadessi.app.post.model.dto.PostUpdateDTO;
import com.youngadessi.app.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(PostCreateDTO postCreateDTO) {
        this.postService.createPost(postCreateDTO);
        return new ResponseEntity<>("Post created successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updatePost(PostUpdateDTO postUpdateDTO) {
        this.postService.updatePost(postUpdateDTO);
        return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        this.postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
