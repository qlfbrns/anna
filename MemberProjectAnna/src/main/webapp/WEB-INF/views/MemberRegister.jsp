<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/Header.jsp"/>
<h1>회원 등록</h1>
<!-- 상대경로 -->
<form action='register' method='post'>
이름: <input type="text" name="mname"><br>
이메일: <input type="text" name="email"><br>
비밀번호: <input type="password" name="pwd"><br>
<input type="submit" value="추가">
<input type="reset" value="취소">
<input type="button" onclick="location.href='list'" value="리스트로 돌아가기">
</form>

<jsp:include page="./include/Footer.jsp"/>