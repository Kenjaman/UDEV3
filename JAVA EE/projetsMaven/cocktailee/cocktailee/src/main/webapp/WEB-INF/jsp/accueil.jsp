<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Cocktail EE</title>
  </head>
  <body>
  	<a href="<c:url value="/commande"/>">Commander</a>  </br>
  	<a href="<c:url value="/recapCommande"/>">Les commandes à traiter</a>  
  </body>
</html>