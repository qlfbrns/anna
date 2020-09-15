<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ page import="com.hk.member.vo.Member" %>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>hk Member</title>

  <!-- Custom fonts for this template -->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

<div style="background-color:#00008b;color:#ffffff;height:40px;padding:5px;">
SPMS(Simple Project Management Style)
<!-- 여기에서 if조건절에 member.getEmail() !=null 이라고 하면 이 문장 자체가 member에서 값을 꺼낸다는 거자나 그래서 성립이 안되 -->
<!-- 그래서 그냥 member자체로 해야 로그인이 안되있는 상황에서 (else문) "값이 비었으면" 이라는 조건이 성립이되서  -->
<!-- 아!로그인이 안되있으니 헤더에 로그인이라는 문구가 나오겠지?? -->
<%if(loginMember!=null){ %>
<span style="float:right;">
${loginMember.mname}
<a style="color:white;" href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
</span>
<%} else{ %>
	<span style="float:right;">
	<a style="color:white;" href="${pageContext.request.contextPath}/auth/login">로그인</a>
	</span>
<%} %>
</div>
  <!-- Page Wrapper -->
  <div id="wrapper">