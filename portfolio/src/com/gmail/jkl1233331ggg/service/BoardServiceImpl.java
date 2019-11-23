package com.gmail.jkl1233331ggg.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.jkl1233331ggg.dao.BoardDao;
import com.gmail.jkl1233331ggg.domain.Board;
import com.gmail.jkl1233331ggg.domain.User;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public void register(HttpServletRequest request) {
		// 매개변수가 request일 때는 파라미터를 읽습니다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User)request.getSession().getAttribute("user");
		String email = user.getEmail();
		if (title.length() == 0) {
			title = "무제";
		}
		if (content.length() == 0) {
			content = "냉무";
		}
		// 필요한 데이터를 생성
		String ip = request.getRemoteAddr();
		Board vo = new Board();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setEmail(email);
		vo.setIp(ip);
		vo.setNickname(user.getNickname());
		// DAO의 메소드를 호출
		boardDao.register(vo);
	}
	
	@Override
	public List<Board> list() {
		List<Board> list = boardDao.list();
		return list;
	}
	
	@Override
	public Board detail(int bno){
		return boardDao.detail(bno);
	}


}
