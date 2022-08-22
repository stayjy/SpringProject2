<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>member/main.jsp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/minty/bootstrap.min.css" integrity="sha384-H4X+4tKc7b8s4GoMrylmy2ssQYpDHoqzPa9aKXbDwPoPUA3Ra8PA5dGzijN+ePnH" crossorigin="anonymous">
</head>
<body>
<%
// String id=(String)session.getAttribute("id");
// 세션값이 없으면(세션값이 null이면) loginForm.jsp 이동
// if(id==null){
// 	response.sendRedirect("loginForm.jsp");
// }

//jsp 화면에서 태그처럼 if, for 사용
//JSTL (JSP standard Tag Lib)
//1. JSTL 프로그램 설치

%>
<c:if test="${empty sessionScope.id }">
	<c:redirect url="/member/login"></c:redirect>
</c:if>

${sessionScope.id }님 로그인 하셨습니다. 
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath }/member/info">회원정보조회</a>
<a href="${pageContext.request.contextPath }/member/update">회원정보수정</a>
<a href="${pageContext.request.contextPath }/member/delete">회원정보삭제</a>



<%
// if(id!=null){
// 	if(id.equals("admin")){
		%> 

<c:if test="${ !( empty sessionScope.id )}">
	<c:if test="${sessionScope.id eq 'admin'}">
		<a href="${pageContext.request.contextPath }/member/list">회원목록</a>
	</c:if>
</c:if>


</body>
</html>


