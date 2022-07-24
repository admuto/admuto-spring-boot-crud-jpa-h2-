package com.admuto.crud.service;

import java.util.List;
import java.util.Optional;

import com.admuto.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.admuto.crud.dao.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return (List<User>) userRepository.saveAll(users);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User updateUser(User user) {
        User oldUser=null;
        Optional<User> optionaluser=userRepository.findById((long) user.getId());
        if(optionaluser.isPresent()) {
            oldUser=optionaluser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            userRepository.save(oldUser);
        }else {
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User got deleted";
    }

}