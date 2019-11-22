<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Cocktail EE</title>
   </head>
  <body>
	<div>
	<h2> Commande numero <c:out value='${laCommande.id}'/></h2>
	<h3>Heure commande prise :
	<fmt:formatDate pattern="dd MMMM YYYY HH:MM:s" value="${laCommande.heureCommande}"/>
	</h3>
		<p><c:out value='${laCommande.cocktail.nom}'/> 
		pour la 
		<c:out value='${laCommande.numeroTable}'/></p>
	<div>
	  	<a href="<c:url value="/"/>">Retour à l'accueil</a>  
	</div>
  
  </body>
</html>