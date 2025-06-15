package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.Entity.UserModel;

import java.util.List;

public interface AdminService {
    UserModel addAdmin(UserModel user); // Now uses UserModel with Role.ADMIN
    List<UserModel> getUsers();
    List<UserModel> getVolunteers();
    UserModel getUserById(long id);
    void deleteUserById(long id);

}
