package com.kiwicare.localhelp.Controller;

import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AdminService adminService;

    //  Fetch volunteers for USER role
    @GetMapping("/volunteers")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<UserModel>> getVolunteersForUser() {
        return ResponseEntity.ok(adminService.getVolunteers());
    }
}
