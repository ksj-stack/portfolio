package com.gmail.jkl1233331ggg.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gmail.jkl1233331ggg.domain.User;

public interface UserService {
	public String emailcheck(String email);
	public String nicknamecheck(String nickname);
	public int register(MultipartHttpServletRequest request);
	public User login(User user);

}
