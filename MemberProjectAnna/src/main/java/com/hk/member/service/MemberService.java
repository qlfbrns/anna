package com.hk.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.member.dao.MemberDao;
import com.hk.member.mapper.MemberMapper;
import com.hk.member.vo.Member;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
//	
//	public List<Member> memberList(){
//		
//		return memberMapper.memberList();
//	}
	
	@Autowired
	MemberDao memberDao;
	
	public List<Member> memberList(){
		return memberDao.memberList();
	}
	
	public int memberRegister(Member member) {
		int retVal = memberMapper.memberRegister(member);
		System.out.println("retVal =" + retVal);
		return retVal;
	}
	
	public Member memberGetOne(int mno) {
		return memberMapper.memberGetOne(mno);
	}

	public int memberUpdate(Member member) {
		int retVal=memberMapper.memberUpdate(member);
		return retVal;
	}
	
	public int memberDelete(int mno) {
		return memberMapper.memberDelete(mno);
	}
	
	public Member memberExist(Member member) {
		return memberMapper.memberExist(member);
	}
}
