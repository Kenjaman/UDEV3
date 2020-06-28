<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PermApp - Liste des plantes</title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a>
	</nav>
	<ul>
		<c:forEach items="${plantes}" var="plante">
			<li><a href="<c:url value='/plante/${plante.id}'/>"><c:out value="${plante.nom}"/></a></li>
		</c:forEach>
	</ul>
</body>
</html>