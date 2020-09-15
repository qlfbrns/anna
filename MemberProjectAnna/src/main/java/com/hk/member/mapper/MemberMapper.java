package com.hk.member.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.member.vo.Member;

@Repository
public interface MemberMapper {

	//메소드명이 MemberMapper.xml에 등록해놓은 id이름과 같아야해, 대소문 구분잘하기!!!
	public List<Member> memberList();
	
	public int memberRegister(Member member);
	
	public Member memberGetOne(int mno);
	
	public int memberUpdate(Member member);
	
	public int memberDelete(int mno);
	
	public Member memberExist(Member member);
}
