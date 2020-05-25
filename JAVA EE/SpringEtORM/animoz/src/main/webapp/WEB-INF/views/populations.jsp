<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz - Liste des populations</title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a> 
		<a href="<c:url value='/ajoutPopulation'/>">Recenser une population</a>
		<a href="<c:url value='/populations/rapport.xlsx'/>" target="_bank">Obtenir la liste</a>

	</nav>
		<c:forEach items="${populations}" var="population">
		<section>
			<p>Nom de l'animal : <c:out value="${population.animal.nom}" /></p>
			<ul>
				<li>Nombre d'individus : <c:out value="${population.nombreIndividus}" /></li>
				<li>Numéro de l'enclos : <c:out value="${population.enclos.numero}" /></li>
			</ul>
		</section>
		</c:forEach>
</body>
</html>