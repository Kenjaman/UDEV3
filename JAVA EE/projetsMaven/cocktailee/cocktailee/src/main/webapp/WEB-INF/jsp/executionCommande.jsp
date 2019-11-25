<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <style><%@include file="/WEB-INF/styles/tabCommande.css"%></style>
<title>La commande</title>
</head>
<body>
	<div>
		<p> Commande : ${laCommande.cocktail} venant de la table ${laCommande.numeroTable} </p>
		<form method="GET" action=""><input type="hidden" name="traiter" value="${laCommande.id}"/><input type="submit" value = "Commande terminée"/></form>
	</div>
	

</body>
</html>