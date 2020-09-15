package com.hk.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hk.member.vo.Member;

public class MyInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//파라메터로 넣은게 톰캣한테 넣어달라고 한거야 그래서 일반 클래스이지만 session에 접근가능..
		//여기서 로그인 체크
		//session 객체를 가져옴
		HttpSession session = request.getSession();
		
		//login처리를 담당하는 사용자 정보를 담고있는 객체를 가져옴
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if (loginMember==null) {
			//로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect("/auth/login");
			return false;//더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
		}
		return true;
	}
}
