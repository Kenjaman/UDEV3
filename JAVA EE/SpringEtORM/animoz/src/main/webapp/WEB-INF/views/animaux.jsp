<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz - Liste des animaux</title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a>
		<a href="<c:url value='/ajoutAnimal'/>">Ajouter un animal</a>
		<a href="<c:url value='/animaux/liste.pdf'/>" target="_bank">Obtenir la liste</a>
		
	</nav>
	<ul>
		<c:forEach items="${animaux}" var="animal">
			<li><a href="<c:url value='/animal/${animal.id}'/>"><c:out value="${animal.nom}"/></a></li>
		</c:forEach>
	</ul>
</body>
</html>