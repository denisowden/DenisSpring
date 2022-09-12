package com.example.denisspring.controller;

import com.example.denisspring.entity.User;
import com.example.denisspring.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class SimpleController {

  private final UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @GetMapping(value = "/{id}")
  public User getUsers(@PathVariable Integer id) {
    return userService.getUser(id);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping(value = "/{id}")
  public User updateUser(@RequestBody User user, @PathVariable Integer id) {
    return userService.updateUser(user, id);
  }

  @DeleteMapping(value = "/{id}")
  public Integer deleteUser(@PathVariable Integer id) {
    return userService.deleteUser(id);
  }
}
