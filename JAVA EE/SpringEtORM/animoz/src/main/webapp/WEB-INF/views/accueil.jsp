<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz</title>
</head>
<body>
	<p>Bienvenue sur Animoz&nbsp;!</p>
	<nav>
		<a href="<c:url value='/espece'/>">Liste des espèces</a>
		<a href="<c:url value='/animal'/>">Liste des animaux</a>
		<a href="<c:url value='/enclos'/>">Liste des Enclos</a>
		<a href="<c:url value='/ajoutPopulation'/>">Ajouter des populations</a>
		
	</nav>
</body>
</html>