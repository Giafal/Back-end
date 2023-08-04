package com.epicode.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.security.entity.User;
import com.epicode.security.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repo;
	@Autowired @Qualifier("userBean") private ObjectProvider<User> userProvider;
	
	
	public User findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void modificaUser(User u) {
		repo.save(u);
	}

}
