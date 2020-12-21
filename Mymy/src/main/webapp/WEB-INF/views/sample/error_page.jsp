<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h4><c:out value="${exception.getMessage()}"></c:out></h4>
	
	<ul>
		<c:forEach items="${exception.getStackTrace() }" var="stack">
			<li><c:out value="${stack}"></c:out></li>
			</c:forEach>
	</ul>
</body>
</html>