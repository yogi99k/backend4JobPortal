package com.eazybytes.backend.controller;

import com.eazybytes.backend.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users/")
public class UserController {

    @GetMapping({"{userId}/posts", "{userId}/posts/{postId}"})
    public ResponseEntity<String> searchUserPostWithMultiPathVariables(@PathVariable("userId") Long userId, @PathVariable (value="postId", required = false) Long postId) {
        String response;
        if (postId == null) {
            response= "Fetching all posts for user with id " + userId;
        }else{
                response= "Fetching post with id " + postId + " for user with id " + userId;
        }
        //return response;
        return ResponseEntity.ok(response);
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

    @PostMapping("request-entity")
    public ResponseEntity<String> createUserUsingRequestEntity(RequestEntity<UserDto> requestEntity){
        requestEntity.getUrl().getPath();
        UserDto body = requestEntity.getBody();
        requestEntity.getUrl().getQuery();
        requestEntity.getHeaders();
//        return "created user with data "+requestEntity.toString();
        return ResponseEntity.status(HttpStatus.CREATED).body("created user with data "+body.toString());
    }
}
