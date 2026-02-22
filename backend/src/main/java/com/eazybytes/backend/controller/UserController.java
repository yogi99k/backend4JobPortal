package com.eazybytes.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping({"/api/dummy/users/{userId}/posts", "/api/dummy/users/{userId}/posts/{postId}"})
    public String searchUserPostWithMultiPathVariables(@PathVariable("userId") Long userId,@PathVariable (value="postId", required = false) Long postId) {
        if (postId == null) {
            return "Fetching all posts for user with id " + userId;
        }
        return "Fetching post with id " + postId + " for user with id " + userId;
    }
}
