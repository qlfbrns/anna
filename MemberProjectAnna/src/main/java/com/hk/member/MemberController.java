package com.hk.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.member.service.MemberService;
import com.hk.member.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String memberList(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("members", memberService.memberList() );
		
		return "MemberList";
	}
	
	@GetMapping("/member/register")
	//굳이 spring한테 받을게 없어서 locale없이 model만 있다. 메소드내에서 쓸 필요가 없어서..
	public String memberRegisterGet(Model model) {
		//사용자가 입력을 할 수 있도록 html만 보내준다.
		logger.info("/member/register 호출");
		//servlet-context.xml에 정의되어있음(호출방법)
		return "MemberRegister";
	}
	
	//getmapping과 postmapping은 서버에서 인식하는게 다르다 
	//그래서 url이 같아도 괜찮아
	//http에서 인식하는? 방식에따라서 url은 같아도 되
	@PostMapping("/member/register")
	//기존에 getParameter로 Member에 mname, email등등 하나씩 우리가 코드로 해서 넣어쭸는데
	//우리가 Member 파라메터롤 넣어주면 스프링이 저 작업을 대신 해서 vo에 사용자입력값을 넣어준다
	//그래서 이제 서비스랑 mapper등으로 전달전달이 된다.
	public String memberRegisterPost(Model model, Member member) {
		//사용자가 입력한 값을 가져온다.
		//request.getParameter는 예전 서블릿방식
		//@RequestParam을 이용하여 가져온다
		//DTO를 선언한다. 클라이언트에 있는 html name값이 DTO와 동일하면
		//Spring에서 알아서 넣어준다.
		logger.info("/member/registerPost 호출");
		
		logger.info("사용자에게 입력받은 값 ="+member.toString());
		//db작업필요해서 서비스를 호출
		int retVal = memberService.memberRegister(member);
		logger.info("insert후에 성공인지 실패인지 알려줌 ["+retVal+"]");
		model.addAttribute("name", member.getMname());
		return "MemberRegisterDone";
	}
	
	@GetMapping("/member/update")
	public String memberUpdateGet(@RequestParam("mno") int mno, Model model) {
		//db에 입력되어 있는 값을 1개 조회해서
		//model에 넣는가
		//@ㄲㄷ볃ㄴ솀ㄱ므형태로 가져옴
		logger.info("/member/memberUpdateGet 호출");
		
		logger.info("사용자에게 입력받은 값=" + mno);
		model.addAttribute("member", memberService.memberGetOne(mno));
		return "MemberUpdateGet";
	}
	
	@PostMapping("/member/update")
	public String memberUpdatePost(Member member, Model model) {
		//db에 입력되어 있는 값을 1개 조회...
		memberService.memberUpdate(member);
		model.addAttribute("member", member);
		return "MemberUpdatePost";
	}
	
	@GetMapping("/member/delete")
	//mno을 받아와서 int mno에 넣어라
	public String memberDeleteGet(@RequestParam("mno") int mno, Model model) {
		logger.info("/member/delete 호출");
		//그래서 여기서 model에 그냥 "mno",mno해서 mno만 넣어서 주고받고도 해도괴, 
		//그럼 대신 jsp파일에서 번호로 7번을 진짜 지우겠냐 이렇게 떠, 나는 이름으로 하려고 memer에 정보를 다 넣은거고
		model.addAttribute("member", memberService.memberGetOne(mno));
		return "MemberDeleteGet";
	}
	
	@PostMapping("/member/delete")
	public String memberDeletePost(@RequestParam("mno") int mno, Model model) {
		model.addAttribute("member", memberService.memberGetOne(mno));
		model.addAttribute("result", memberService.memberDelete(mno));
		return "MemberDeletePost";
	}
	
//	@GetMapping("/auth/login")
//	public String memberExistGet(Model model) {
//		return "MemberLoginGet";
//	}
//	
//	@PostMapping("/auth/login")
//	public String memberLogin(HttpSession session, Member member) {
//		logger.info("이메일:"+member.getEmail()+"비번:"+member.getPwd());
//		member=memberService.memberExist(member);
//		boolean isLogin = member!=null;
//		if(isLogin) {
//			session.setAttribute("member", member);
//			return "redirect:/member/list";
//		} else {
//			return "MemberLoginGet";
//		}
//		
//	}
	
	@GetMapping("/auth/logout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/list";
	}
}

