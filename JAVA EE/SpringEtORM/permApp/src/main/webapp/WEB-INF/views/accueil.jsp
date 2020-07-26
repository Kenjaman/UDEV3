<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PermApp</title>
</head>
<body>
	<p>Bienvenue sur PermApp&nbsp;!</p>
	<nav>
		<a href="<c:url value='/plantes'/>">Liste des plantes</a>
		<a href="<c:url value='/ajoutPlante'/>">Ajouter une plante</a>
		<p> Test </p>
	</nav>
</body>
</html>