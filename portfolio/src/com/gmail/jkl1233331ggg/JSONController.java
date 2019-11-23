package com.gmail.jkl1233331ggg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.jkl1233331ggg.service.UserService;

@RestController
public class JSONController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="emailcheck", method = RequestMethod.GET)
	public Map<String, Object> emailcheck(String email){
		Map<String, Object>map = 
			new HashMap<String, Object>();
		String result = userService.emailcheck(email);
		map.put("result", result == null);
		return map;
	}
	
	@RequestMapping(value="nicknamecheck", method = RequestMethod.GET)
	public Map<String, Object> nicknamecheck(@RequestParam("nickname") String nickname){
		Map<String, Object>map = 
			new HashMap<String, Object>();
		String result = userService.nicknamecheck(nickname);
		map.put("result", result == null);
		return map;
	}

}

