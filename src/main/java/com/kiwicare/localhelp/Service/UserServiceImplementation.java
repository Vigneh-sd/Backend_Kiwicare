package com.kiwicare.localhelp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.*;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserModel> addUser(List<UserModel> user)
	{
		return userRepository.saveAll(user);
	}


}
