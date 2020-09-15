<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="include/Header.jsp" %>

<%-- <c:forEach var="members" items="${members}"> --%>
<%-- ${members.mno}, ${members.mname}, ${members.email}, ${members.pwd}, ${members.cre_date}, ${members.mod_date}<br> --%>
<%-- </c:forEach> --%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">MEMBER</h1>
          <p class="mb-4">회원 리스트
          &nbsp;&nbsp;&nbsp;<a href="register">산규회원 등록</a>
          
          </p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">

            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#회원번호</th>
                      <th>이름</th>
                      <th>이메일</th>
                      <th>패스워드</th>
                      <th>가입일</th>
                      <th>수정일</th>
                      <th>수정/삭제</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="members" items="${members}">
                    <tr>
                      <td><c:out value="${members.mno}" /></td>
                      <td><a href='update?mno=<c:out value="${members.mno}" />' ><c:out value="${members.mname}" /></a></td>
                      <td><c:out value="${members.email}" /></td>
                      <td><c:out value="${members.pwd}" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${members.cre_date}" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${members.mod_date}" /></td>
                      <td><input type="button" onclick="location.href='delete?mno=<c:out value="${members.mno}" />'" value="삭제">
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

<%@ include file="include/Footer.jsp" %>

</body>
</html>