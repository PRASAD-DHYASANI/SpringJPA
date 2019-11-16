package com.dhyasani.user.service;

import com.dhyasani.user.model.User;
import com.dhyasani.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public List<User> findByName(String name) {
        return userRepository.findByFirstName(name);
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.getOne(id) ;
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public boolean addUser(User user) {
        return userRepository.save(user) != null;
    }

    @Transactional
    public boolean updateUser(User user) {
        return userRepository.save(user) != null;
    }
}
