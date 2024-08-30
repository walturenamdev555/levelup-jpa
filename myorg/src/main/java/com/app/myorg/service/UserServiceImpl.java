package com.app.myorg.service;

import com.app.myorg.entity.User;
import com.app.myorg.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepo userRepo;


  @Override
  public User saveUser(User user) {
    return userRepo.save(user);
  }
}
