package com.hk.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.member.service.MemberService;
import com.hk.member.vo.Member;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	MemberService memberService;
	@GetMapping("/login")
	public String memberExistGet(Model model) {
		return "MemberLoginGet";
	}
	
	@PostMapping("/login")
	public String memberLogin(HttpSession session, Member member) {
		//사용자가 입력한 email/password를 member에 담아온다.
		//password 체크하는 service에 넘겨서 값을 받아옴
		//성공이면 session에 member정보 담아두고 /member/list로 보내고
		//실패면 다시 login페이지로 이동
		//아래 if문은 MemberService에서 전부 
		//@RequestPara("email") String email, 이렇게핻 되는데 귀찮아서 dto그냥 넣은거야
		Member loginMember=memberService.memberExist(member);
		boolean isLogin = loginMember!=null;
		if(isLogin) {
			session.setAttribute("loginMember", loginMember);
			//여기 session에 넣은거는 나중에 헤더에서 interceptor를 이용해서 꺼내쓴다..!
			//model이라고 하는 보관소에 넣었음..
			//servlet할때는 context(전체), session(로그인), request(접속마다)..
			//스프링은 pojo형식으로 일반 클래스라 저거 3개 못해서 model을 쓴거고..
			//spring으로 넘어오면서 model로 합쳐서 사용
			//근데 지금은 spring을 쓰면서 Servlet할때 Session을 사용
			//DispatcherServlet이 서블릿이니까 httpSession을 여기에 준거야
			return "redirect:/member/list";
		} else {
			return "MemberLoginGet";
		}
		
	}
}
