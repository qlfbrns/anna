package com.hk.member;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.member.service.MemberService;
import com.hk.member.vo.Member;



@RestController
@RequestMapping(value="/member/rest", produces="text/plain;charset=UTF-8")
public class RestMemberController {

	private static final Logger logger=LoggerFactory.getLogger(RestMemberController.class);
	
	@Autowired
	MemberService memberService;
	//기존에는 첨부터 @Controller만 어노테이션해서 url을 풀로 지정,
	//이거는 이제 Rest로 바꾼거야. 그래서 @RestController로해서
	//@RequestMapping, @GetMapping나눠서 url 지정하고..리턴값이 달라.
	//여기에서는 /list 이 url이 들어오면 리턴을 String타입만 주는거야.
	//기존에는 jsp파일을 찾아서 html로해서 클라이언트가 그거를 실행해서 화면을 출력했다면
	//이거는 그냥 글자만 주고 니가 알아서해 하는거얌
	@GetMapping("/list")
	public String memberList(Locale local, Model model) {
		 logger.info("/member/rest/list ----------");
		return "이건 서버에서 보내준 /member/rest/list";
	}
	
	//json은 mxl을 축약한 버전..
	//mvn repository에서 depedency등록 후 사용..
	@GetMapping(path="/listJson", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Member> memberRestListJson(Locale local, Model model) {
		return memberService.memberList();
	}
	
	@GetMapping(path="/listXml", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Member> memberRestListXml(Locale locale, Model model) {
		return memberService.memberList();
	}
	
	
}
