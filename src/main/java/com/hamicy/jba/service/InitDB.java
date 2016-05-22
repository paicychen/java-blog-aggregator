package com.hamicy.jba.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamicy.jba.repository.*;
import com.hamicy.jba.entity.*;

@Transactional
@Service
public class InitDB {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init(){
		Role adminRole = new Role();
		adminRole.setName("Admin Role");
		roleRepository.save(adminRole);
		
		Role userRole = new Role();
		userRole.setName("User Name");
		roleRepository.save(userRole);
		
		User adminUser = new User();
		adminUser.setName("Admin");
		ArrayList<Role> roles = new ArrayList();
		roles.add(adminRole);
		roles.add(userRole);
		adminUser.setRoles(roles);
		userRepository.save(adminUser);
		
		Blog blog = new Blog();
		blog.setName("JavaVids");
		blog.setUrl("http://feeds.feedburner.com/javavids?former=xml");
		blog.setUser(adminUser);
		blogRepository.save(blog);
		
		Item item1 = new Item();
		item1.setBlog(blog);
		item1.setTitle("First");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blog);
		item2.setTitle("First");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);		
						
	}
}
