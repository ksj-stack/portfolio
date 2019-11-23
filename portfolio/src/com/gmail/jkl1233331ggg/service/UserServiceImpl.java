package com.gmail.jkl1233331ggg.service;

import java.io.File;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gmail.jkl1233331ggg.dao.UserDao;
import com.gmail.jkl1233331ggg.domain.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public String emailcheck(String email) {
		return userDao.emailcheck(email);
	}
	
	@Override
	public String nicknamecheck(String nickname) {
		return userDao.nicknamecheck(nickname);
	}

	@Override
	public int register(MultipartHttpServletRequest request) {
		int result = 0;
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		MultipartFile image = request.getFile("image");

		String uploadPath = request.getServletContext().getRealPath("/userimage");

		String filename = image.getOriginalFilename();
		
		if(filename.length() >0) {
			String []  ar = filename.split("\\.");
			if(ar.length == 1) {
				filename = "";
			}else if(!ar[1].toLowerCase().equals("jpg") && 
					!ar[1].toLowerCase().equals("gif") && 
					!ar[1].toLowerCase().equals("png") && 
					!ar[1].toLowerCase().equals("jpeg")){
				filename = "";
			}
		}
		
		
		User user = new User();
		try {
			if (filename.length() > 0) {
				String [] ar  = email.split("@");
				
				filename = ar[0] + "_" + filename;
				// 저장된 파일 경로 만들기
				String filepath = uploadPath + "/" + filename;
				// 파일 업로드
				File file = new File(filepath);
				image.transferTo(file);
			} else {
				filename = "default.png";
			}
			user.setImage(filename);
			user.setEmail(email);
			user.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
			user.setNickname(nickname);
			result = userDao.register(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	@Override
	public User login(User user) {
		User loginUser = userDao.login(user);
		if (loginUser != null) {

			if (BCrypt.checkpw(user.getPw(), loginUser.getPw())) {
				loginUser.setPw(null);
			} else {
				loginUser = null;
			}
		}
		return loginUser;
	}
}

