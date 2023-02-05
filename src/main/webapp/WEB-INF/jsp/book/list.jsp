<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>${test}</p>
  <c:forEach var="data" items="${list}">
     <p>번호 : ${data.idx}</p>
     <p>제목 : ${data.title}</p>
     <p>ISBN : ${data.isbn}</p>
     <p>저자 : ${data.author}</p>
     <p>발행년도 : ${data.yearIssue}</p>
     <p>썸네일 : ${data.thumbnailUrl}</p>
  </c:forEach>
</body>
</html>