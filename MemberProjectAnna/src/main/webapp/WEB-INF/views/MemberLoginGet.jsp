<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/Header.jsp"/>
<h2>로그인</h2>
<form action="login" method="post">
E-mail: <input type="text" name="email"><br>
비밀번호: <input type="password" name="pwd"><br>
<input type="submit" value="로그인">
</form>