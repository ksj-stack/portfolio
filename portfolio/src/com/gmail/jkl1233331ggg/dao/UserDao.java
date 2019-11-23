package com.gmail.jkl1233331ggg.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.jkl1233331ggg.domain.Board;
import com.gmail.jkl1233331ggg.domain.User;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public String emailcheck(String email) {
		return sqlSession.selectOne("user.emailcheck", email);
	}
	
	public String nicknamecheck(String nickname) {		
		return sqlSession.selectOne("user.nicknamecheck", nickname);	
	}
	
	public int register(User user) {
		return sqlSession.insert("user.register", user);
	}

	public User login(User user) {
		return sqlSession.selectOne("user.login", user);
	}
}
