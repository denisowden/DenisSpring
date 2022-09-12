package com.example.denisspring.service;

import com.example.denisspring.entity.User;
import java.util.List;

public interface UserService {
  List<User> getUsers();
  User getUser(Integer id);
  User createUser(User user);
  User updateUser(User user, Integer id);
  Integer deleteUser(Integer id);
}
