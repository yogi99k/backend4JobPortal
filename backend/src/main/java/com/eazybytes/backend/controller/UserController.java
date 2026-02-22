package com.eazybytes.backend.controller;

import com.eazybytes.backend.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users/")
public class UserController {

    @GetMapping({"{userId}/posts", "{userId}/posts/{postId}"})
    public String searchUserPostWithMultiPathVariables(@PathVariable("userId") Long userId,@PathVariable (value="postId", required = false) Long postId) {
        if (postId == null) {
            return "Fetching all posts for user with id " + userId;
        }
        return "Fetching post with id " + postId + " for user with id " + userId;
    }

    @GetMapping({"{userId}/orders/{orderId}","{userId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name="userId") Long customerId,
                                                        @PathVariable(required = false) Long orderId){
        return "Fetching post with id " + orderId + " for user with id " + customerId;
    }

    /**
     * required=false does NOT work with Map
     * @param pathVariablesMap
     * @return
     */
    @GetMapping("{userId}/address/{customerId}")
    public String searchUserAddressrWithMultiPathVariables(@PathVariable Map<String,String> pathVariablesMap){
        return "Fetching post with id " + pathVariablesMap.get("userId") + " for user with id " + pathVariablesMap.get("customerId");
    }

    @GetMapping("search")
    public String searchUserWithMultiQueryParams(@RequestParam(required = false, defaultValue = "Guest") String name, @RequestParam String gender){
        return "Searching user with name " + name + " and " + "gender "+ gender;
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userDto){
        return "Creating user with name " + userDto.name() + " and email " + userDto.email() + " and gender " + userDto.gender();
    }
}
