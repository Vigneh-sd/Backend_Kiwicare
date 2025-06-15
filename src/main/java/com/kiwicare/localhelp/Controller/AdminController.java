package com.kiwicare.localhelp.Controller;

import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addAdmin(@RequestBody UserModel user) {
        adminService.addAdmin(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin Added Successfully!");
    }
    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        adminService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully.");
    }


    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(adminService.getUsers());
    }

    @GetMapping("/volunteers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserModel>> getAllVolunteers() {
        return ResponseEntity.ok(adminService.getVolunteers());
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(adminService.getUserById(id));
    }
}
