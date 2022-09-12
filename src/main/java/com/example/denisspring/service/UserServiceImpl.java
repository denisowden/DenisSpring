package com.example.denisspring.service;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.example.denisspring.exception.UserNotFound;
import com.example.denisspring.entity.User;
import com.example.denisspring.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFound("User with id " + id + " not found"));
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(User user, Integer id) {
    User dbUser = getUser(id);

    if (!isBlank(user.getFirstName())) {
      dbUser.setFirstName(user.getFirstName());
    }
    if (!isBlank(user.getLastName())) {
      dbUser.setLastName(user.getLastName());
    }

    return userRepository.save(dbUser);
  }

  @Override
  public Integer deleteUser(Integer id) {
    userRepository.deleteById(id);
    return id;
  }
}
