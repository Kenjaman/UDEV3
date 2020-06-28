<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz - <c:out value="${animal.nom}"/></title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a>
		<a href="<c:url value='/animal'/>">Liste des animaux</a>
	</nav>
	<h1><c:out value="${animal.nom}"/></h1>
	<section>
		<h2>Origine</h2>
		<p><c:out value="${animal.origine}"/></p>
	</section>
	<section>
		<h2>Espèce</h2>
		<p><c:out value="${animal.espece.nom}"/></p>
	</section>
	<section>
		<h2>Description</h2>
		<p><c:out value="${animal.description}"/></p>
	</section>
	<section>
		<h2>Infos diverses</h2>
		<p>Régime&nbsp;: <c:out value="${animal.regime}"/></p>
		<p>Population totale sur le site&nbsp;: <c:out value="${animal.populationTotale}"/></p>
	</section>
	
</body>
</html>