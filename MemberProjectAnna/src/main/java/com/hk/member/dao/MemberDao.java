package com.hk.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.member.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	DataSource dataSource;
	
	public List<Member> memberList() {
		//MemberDao는 일반 클래스라서 보관소에 접근할 수가 없어, 그래서 컨트롤러(서블릿)가 줘야해 그래서 이제 서블릿 만들거야
		//페이지컨트롤러에서 메소드호출해서 이제 얘 실행할거야
		//db한테 회원목록 정보 싹다 줘 할거야
		//query문 명령해야겠지..?
		Connection connection;
		PreparedStatement pStmt=null;
		ResultSet rs= null;
		String query="select mno, mname, email, pwd, cre_date, mod_date from members";
		List<Member> members=new ArrayList<Member>();
		try {
			connection=dataSource.getConnection();
			pStmt= connection.prepareStatement(query);
			rs=pStmt.executeQuery();
			//이제 db에 접속되서 저 query문이 실행됐어
			//그래서 이제는 db에서 정보 불러온거를 담으면되
			while(rs.next()) {
				Member member=new Member();
				member.setMno(rs.getInt("mno"));
				member.setMname(rs.getString("mname"));
				member.setEmail(rs.getString("email"));
				member.setPwd(rs.getString("pwd"));
				member.setCre_date(rs.getDate("cre_date"));
				member.setMod_date(rs.getDate("mod_date"));
				//이제 이 member를 배열 members에 저장할거야
				members.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pStmt!=null)
				try {
					pStmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		//그래서 이제 이 메소드를 호출한 페이지컨트롤러한테 db에서 받은 정보를 담은 members를 리턴해
		return members;
	}
}