package com.gmail.jkl1233331ggg;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gmail.jkl1233331ggg.domain.Board;
import com.gmail.jkl1233331ggg.domain.User;
import com.gmail.jkl1233331ggg.service.BoardService;
import com.gmail.jkl1233331ggg.service.UserService;


@Controller
public class HomeController {
	// 메인 페이지 접속
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "information.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "information";

	}

	@RequestMapping(value = "school.do", method = RequestMethod.GET)
	public String school(Locale locale, Model model) {
		return "school";
	}

	@RequestMapping(value = "dron.do", method = RequestMethod.GET)
	public String dron(Locale locale, Model model) {
		return "dron";
	}

	@Autowired
	private UserService userService;

	// 회원가입 페이지 이동
	@RequestMapping(value = "register.do", method = RequestMethod.GET)
	public String register(Model model) {
		return "register";
	}

	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String registerPost(MultipartHttpServletRequest request, RedirectAttributes rttr) {
		int result = userService.register(request);
		if (result > 0) {
			rttr.addFlashAttribute("insert", "success");
			return "redirect:/";
		} else {
			return "redirect:register";
		}
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(User user, HttpSession session, Model model, RedirectAttributes attr) {
		User userVO = userService.login(user);
		if (userVO == null) {
			attr.addFlashAttribute("msg", "없는 이메일이거나 비밀번호가 잘못되었습니다.");
			return "redirect:login.do";
		}
		session.setAttribute("user", userVO);
		return "redirect:./";
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:./";
	}

	@RequestMapping(value = "board.do", method = RequestMethod.GET)
	public String boardregister(Board board, Model model, HttpSession session, RedirectAttributes attr){
		if(session.getAttribute("user") == null) {
			attr.addFlashAttribute("msg", "승준이에게 글을 남길려면 로그인을 해야 합니다.");
			return "redirect:./login.do";
		}
		return "board";
	}
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "board.do", method = RequestMethod.POST)
	public String registPOST(HttpServletRequest request,
			RedirectAttributes rttr){
		boardService.register(request);
		rttr.addFlashAttribute("msg", "게시글 작성에 성공하셨습니다.");
		return "redirect:./";
	}

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public void list(Model model){
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String detail(@RequestParam("bno") int bno,Model model){
		model.addAttribute("vo",boardService.detail(bno));
		return "detail";
	}
	
	@RequestMapping(value = "/chat.do", method = RequestMethod.GET)
	public String chat(HttpSession session, RedirectAttributes attr){
		if(session.getAttribute("user") == null) {
			attr.addFlashAttribute("msg", "승준이와 채팅을 할려면 로그인을 해야 합니다.");
			return "redirect:./login.do";
		}
		return "chat";
	}

}
