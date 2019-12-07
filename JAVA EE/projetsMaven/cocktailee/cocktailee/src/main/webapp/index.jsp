<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<link href="<c:url value='/includes/styles/general.css' />" rel="stylesheet"></link> 
  	<link rel="shortcut icon" href="${pageContext.request.contextPath}/includes/images/favicon.ico" />
    <title>Cocktail EE</title>
  </head>
  <body>
  <div class='content'>
   	<a href="<c:url value="/commande"/>">Commander</a>  
  	<a href="<c:url value="/recapCommande"/>">Les commandes à traiter</a>  
  </div>
  </body>
</html>