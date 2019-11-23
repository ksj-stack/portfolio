package com.gmail.jkl1233331ggg.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gmail.jkl1233331ggg.domain.Board;

public interface BoardService {
	public void register(HttpServletRequest request);
	public List<Board> list();
	//글번호를 가지고 하나의 게시글을 가져오는 메소드
	public Board detail(int bno);

}
