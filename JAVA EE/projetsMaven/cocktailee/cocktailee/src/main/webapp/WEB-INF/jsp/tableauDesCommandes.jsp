<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Les commandes à traiter</title>
<link href="<c:url value='/includes/styles/general.css' />"	rel="stylesheet"></link>
<link href="<c:url value='/includes/styles/tabCommande.css' />"	rel="stylesheet"></link>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/includes/images/favicon.ico" />
</head>
<body>
	<div class='content'>
		<table>
		<caption> Liste des commandes à traiter</caption>
			<thead>
				<tr>
					<th>N°Table</th>
					<th>Heure de la prise de commande</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listeCommandes}" var="commande">
				<tr>
				<td><c:out value="${commande.numeroTable}"/></td>
				<td><c:out value="${commande.heureCommande}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<p class='erreur'><c:out value="${errTabEmpty}"/></p>
		<div class="BoutonTab">
			<a href="<c:url value="/execute"/>"><button>Commande suivante</button></a>
			<a id='BoutonRetour' href="<c:url value="/accueil"/>"><button>Retour</button></a>
		</div>

	</div>
	

</body>
</html>