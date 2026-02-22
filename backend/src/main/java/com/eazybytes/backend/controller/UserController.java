package com.eazybytes.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @GetMapping({"/api/dummy/users/{userId}/posts", "/api/dummy/users/{userId}/posts/{postId}"})
    public String searchUserPostWithMultiPathVariables(@PathVariable("userId") Long userId,@PathVariable (value="postId", required = false) Long postId) {
        if (postId == null) {
            return "Fetching all posts for user with id " + userId;
        }
        return "Fetching post with id " + postId + " for user with id " + userId;
    }

    @GetMapping({"/api/dummy/users/{userId}/orders/{orderId}","/api/dummy/users/{userId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name="userId") Long customerId,
                                                        @PathVariable(required = false) Long orderId){
        return "Fetching post with id " + orderId + " for user with id " + customerId;
    }

    /**
     * required=false does NOT work with Map
     * @param pathVariablesMap
     * @return
     */
    @GetMapping("/api/dummy/users/{userId}/address/{customerId}")
    public String searchUserAddressrWithMultiPathVariables(@PathVariable Map<String,String> pathVariablesMap){
        return "Fetching post with id " + pathVariablesMap.get("userId") + " for user with id " + pathVariablesMap.get("customerId");
    }
}
