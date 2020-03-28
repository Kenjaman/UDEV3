<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Nom</h2>
	<p><c:out value="${nom }"></c:out></p>
	
	<h2>Prénom</h2>
	<p><c:out value="${prenom }"></c:out></p>
	
	<h2>Métiers</h2>
	<p>
		<c:forEach items="${metiers}" var="selected">
		    - <c:out value="${selected}" /><br>
		</c:forEach>
	</p>
	
	<h2>Autres métiers</h2>
	<p><c:out value="${autresMetiers }"></c:out></p>
</body>
</html>