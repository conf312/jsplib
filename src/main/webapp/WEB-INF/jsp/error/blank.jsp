<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  //<![CDATA[
    function init() {
      <c:choose>
        <c:when test="${not empty msg}">
          alert("${msg}");
        </c:when>
      </c:choose>
      <c:choose>
        <c:when test="${fn:indexOf(url, 'javascript:') gt -1}">
          location.href = "${url}";
        </c:when>
        <c:otherwise>
          location.replace("${url}");
        </c:otherwise>
      </c:choose>
    }
  //]]>
</script>
</head>
<body onload="init();">
</body>
</html>