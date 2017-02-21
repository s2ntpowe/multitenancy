package net.codejava.spring.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import net.codejava.spring.model.User;
@Component
public interface UserDAO {
	public List<User> list(String tenantId);
}
