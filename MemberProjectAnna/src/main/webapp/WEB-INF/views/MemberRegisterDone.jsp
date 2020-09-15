<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/Header.jsp"/>
<h1>register결과</h1>
<b>정상적으로 입력 완료</b>
<a href="list">클릭 아님 5초</a>
${name}님 등록 완료
<script>
	setTimeout(function() {window.location='list;'}, 3000);
</script>
<jsp:include page="./include/Footer.jsp"/>