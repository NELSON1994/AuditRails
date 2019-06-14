package com.auditing.audit.controller;

import com.auditing.audit.exception.ResourceNotFoundException;
import com.auditing.audit.model.User;
import com.auditing.audit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//---the base of our url will be localhost:8080:/api/v1
@RequestMapping("/api/v1")
public class UserController {

    // ----we autowire our dao interface class----
    @Autowired
    private UserRepository userRepository;

    //---getmapping applied to retrieve all users in a list format---
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // -----for retrieving a user by id------
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + id));

        return ResponseEntity.ok().body(user);
    }

    //----for creating a user-------
//----@Valid is used to check the validation rules set at the entity class----
    //----@RequestBody is user to show what is to be displaed at the body of the entity---

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // ---for updating the user details-------

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Long userId,
            @Valid @RequestBody User u1) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        user.setFirstname(u1.getFirstname());
        user.setLastname(u1.getLastname());
       user.setContact(u1.getContact());
       user.setEmail(u1.getEmail());
       user.setUsername(u1.getUsername());
       user.setPassword(u1.getPassword());
        user.setLastModifiedDate(new Date());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    //---deleting of a user -------
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
