<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>La commande</title>
<link href="<c:url value='/includes/styles/general.css' />"
	rel="stylesheet"></link>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/includes/images/favicon.ico" />
</head>
<body>
	<div class='content'>
		<h3>Commande : ${laCommande.cocktail.nom}</h3>
			<p><em>${laCommande.cocktail.composition}</em> venant de la table
			<strong>${laCommande.numeroTable}</strong>
			</p>

		<div class="executer">
			<form action="" method="POST">
				<input type="submit" value="Commande terminée" />
			</form>
		</div>
			<a href="<c:url value="/recapCommande"/>"><button>Retour
					liste</button></a>
	</div>
</body>
</html>