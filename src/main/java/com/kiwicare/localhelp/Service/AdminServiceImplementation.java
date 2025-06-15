package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.Entity.Role;
import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel addAdmin(UserModel user) {
        user.setRole(Role.ADMIN);
        return userRepository.save(user);
    }
    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<UserModel> getUsers() {
        return userRepository.findAll().stream()
            .filter(user -> user.getRole() == Role.USER)
            .collect(Collectors.toList());
    }

    @Override
    public List<UserModel> getVolunteers() {
        return userRepository.findAll().stream()
            .filter(user -> user.getRole() == Role.VOLUNTEER)
            .collect(Collectors.toList());
    }

    @Override
    public UserModel getUserById(long id) {
        return userRepository.findById(id)
            .filter(user -> user.getRole() == Role.USER || user.getRole() == Role.VOLUNTEER)
            .orElseThrow(() -> new RuntimeException("User not found or role not allowed"));
    }
}
