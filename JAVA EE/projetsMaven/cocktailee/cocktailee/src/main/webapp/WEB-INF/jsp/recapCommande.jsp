<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cocktail EE</title>
<link href="<c:url value='/includes/styles/general.css' />"	rel="stylesheet"></link>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/includes/images/favicon.ico" />
</head>
<body>
	<div class='content' id="recap">
		<h2>
			Commande numero
			<c:out value='${laCommande.id}' />
		</h2>
		<h3>
			Heure d'enregistrement :
			<fmt:formatDate pattern="dd MMMM YYYY HH:MM:s"
				value="${laCommande.heureCommande}" />
		</h3>
		<p>
			<strong><c:out value='${laCommande.cocktail.nom}' /></strong>
			pour la
			<c:out value='${laCommande.numeroTable}' />
		</p>
		<div>
			<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>
		</div>
	</div>

</body>
</html>