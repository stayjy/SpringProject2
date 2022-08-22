<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
</head>
<body>
<%
// 로그인하면 세션값이 생성 => 페이지 상관없이 값이 유지 => 세션값 가져오기
// String id=(String)session.getAttribute("id");
// // MemberDAO 객체생성
// MemberDAO memberDAO=new MemberDAO();
// // 리턴할형 MemberDTO getMember(String id) 메서드 정의
// // MemberDTO memberDTO = getMember(id) 메서드 호출
// MemberDTO memberDTO=memberDAO.getMember(id);
//컨트롤, dao, service 단에서 위의 코드들을 다 처리했음.

// %없애고 jsp화면에서 태그처럼 출력, 연산자, 내장객체 사용 sessionScope사용
// 표현언어 el(프로그램 설치 없이 사용 가능) expression language / ${출력할내용}
//jsp 화면에서 태그처럼 if, for 사용
// JSTL(JSP Standard Tag Lib)
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
	<tr><td>${memberDTO.id}</td>
	    <td>${memberDTO.pass}</td>
	    <td>${memberDTO.name}</td>
	    <td>${memberDTO.date}</td>
	</tr>
</table>
<a href="${pageContext.request.contextPath }/member/main">메인으로 이동</a>
</body>
</html>
