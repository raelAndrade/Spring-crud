package br.com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.demo.model.User;
import br.com.demo.repository.UserRepository;

@Controller
@RequestMapping("/usuario")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastraUsuario")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("user/cadastraUsuario");
		mv.addObject("userObj",new User());
		return mv;
	}
		
	@RequestMapping(method=RequestMethod.POST, value="**/salvaUsuario")
	public ModelAndView save(User user) {
		repository.save(user);
		
		ModelAndView mv = new ModelAndView("user/cadastraUsuario");
		List<User> userList = repository.findAll();
		mv.addObject("usuarios", userList);
		mv.addObject("userObj",new User());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaUsuario")
	public ModelAndView listarUsuario() {
		ModelAndView mv = new ModelAndView("user/cadastraUsuario");
		List<User> userList = repository.findAll();
		mv.addObject("usuarios", userList);
		mv.addObject("userObj",new User());
		return mv;
	}
	
	@GetMapping("/editaUsuario/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Optional<User> user = repository.findById(id);
		
		ModelAndView mv = new ModelAndView("user/cadastraUsuario");
		mv.addObject("userObj", user.get());
		return mv;
	}
	
	@GetMapping("/removeUsuario/{id}")
	public ModelAndView remove(@PathVariable Long id){
		repository.deleteById(id);
		
		ModelAndView mv = new ModelAndView("user/cadastraUsuario");
		mv.addObject("usuarios", repository.findAll());
		mv.addObject("userObj", new User());
		return mv;
	}

}
