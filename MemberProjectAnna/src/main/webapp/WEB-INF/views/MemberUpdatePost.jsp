<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/Header.jsp"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>updat 결과</h1>
<b>${member.mname }님 수정 완료</b>
<a href="list">리스트로 이동사려면 눌러</a>
<script>
	setTimeout(function() {window.location='list';}, 5000);
</script>
<jsp:include page="./include/Footer.jsp"/>