package com.acme.tukibackend.controller.account;

import com.acme.tukibackend.model.account.User;
import com.acme.tukibackend.resource.account.SaveLoginResource;
import com.acme.tukibackend.resource.account.UserResource;
import com.acme.tukibackend.resource.account.SaveUserResource;
import com.acme.tukibackend.service.account.UserService;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "https://tukilatam.vercel.app", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserResource login(@Valid @RequestBody SaveLoginResource resource) {
        return convertToResource(userService.login(resource.getEmail(),resource.getPassword()));
    }

    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable) {
        List<UserResource> users = userService.getAllUsers(pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int usersCount = users.size();
        return new PageImpl<>(users, pageable, usersCount);
    }

    @GetMapping("/users/{id}")
    public UserResource getUserById(@PathVariable(name = "id") Long userId) {
        return convertToResource(userService.getUserById(userId));
    }

    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource) {
        return convertToResource(userService.createUser(convertToEntity(resource)));
    }

    @PutMapping("/users/{id}")
    public UserResource updateUser(@PathVariable(name = "id") Long tagId, @Valid @RequestBody SaveUserResource resource) {
        return convertToResource(userService.updateUser(tagId, convertToEntity(resource)));
    }


    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }
}
