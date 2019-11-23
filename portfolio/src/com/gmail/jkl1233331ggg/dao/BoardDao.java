package com.gmail.jkl1233331ggg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.jkl1233331ggg.domain.Board;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void register(Board vo) {
		sqlSession.insert("board.register", vo);
	}
	
	public List<Board> list() {
		return  sqlSession.selectList("board.list");
	}

	public Board detail(int bno) {
		return sqlSession.selectOne("board.detail", bno);
	}

}
