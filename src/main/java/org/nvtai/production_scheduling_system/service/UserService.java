package org.nvtai.production_scheduling_system.service;

import org.nvtai.production_scheduling_system.entity.User;
import org.nvtai.production_scheduling_system.mapper.UserMapper;
import org.nvtai.production_scheduling_system.model.UserModel;
import org.nvtai.production_scheduling_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserModel authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && user.isActive()) {
            return userMapper.toModel(user);
        }
        return null;
    }

}