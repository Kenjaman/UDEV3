<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@include file="/WEB-INF/styles/tabCommande.css"%>
</style>
<title>La commande</title>
</head>
<body>
	<div class='content'>
		<p>Commande : ${laCommande.cocktail.nom} (${laCommande.cocktail.composition}) venant de la table
			${laCommande.numeroTable}</p>
	</div>
	<div class='BoutonTab'>
		<form action="" method="POST"><input type="submit" value="Commande terminée"/></form>
		<a href="<c:url value="/recapCommande"/>"><button>Retour liste</button></a>
	</div>
</body>
</html>