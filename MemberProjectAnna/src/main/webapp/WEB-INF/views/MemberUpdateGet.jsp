<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/Header.jsp"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>회원 등록</h1>
<!-- 상대경로 -->
<form action='update' method='post'>
번호: <input type="text" name="mno" value="${member.mno }" readonly><br>
이름: <input type="text" name="mname" value="${member.mname }"><br>
이메일: <input type="text" name="email" value="${member.email }"><br>
비밀번호: <input type="password" name="pwd" value="${member.pwd }"><br>
가입일: <fmt:formatDate pattern="yyyy-MM-dd" value="${member.cre_date}" /><br>
<input type="submit" value="추가">
<input type="reset" value="취소">
<input type="button" onclick="location.href='list'" value="리스트로 돌아가기">
</form>

<jsp:include page="./include/Footer.jsp"/>

