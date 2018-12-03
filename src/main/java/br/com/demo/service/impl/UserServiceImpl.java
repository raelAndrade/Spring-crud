package br.com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.demo.model.User;
import br.com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserService userService;
	
	public User getUserFindOne(Long id) {
		return userService.getUserFindOne(id);
	}

	public List<User> listAll() {
		return userService.listAll();
	}

	public User save(User usuario) {
		return userService.save(usuario);
	}

	public User update(User usuario) {
		getUserFindOne(usuario.getId());
		return userService.update(usuario);
	}

	public void delete(Long id) {
		getUserFindOne(id);
		userService.delete(id);
	}

}
