<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Entrée Commande</title>
    <link href="<c:url value='/includes/styles/general.css' />"	rel="stylesheet"></link>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/includes/images/favicon.ico" />  </head>
  <body>
	<div class="content">
	<form method="post" accept-charset="utf-8">
		<div>
			<label for="cocktail">Cocktail : </label>
			<select id="cocktail" name="cocktail">
				<option value="0">-- Choisissez --</option>
				<c:forEach var="cocktail" items="${listeCocktails}">
					<option value="${cocktail.id}" ${param['cocktail'] == cocktail.id ? "selected" : ""}>
						<c:out value="${cocktail.nom}"/>
					</option>
				</c:forEach>
			</select>
			<p class='erreur'><c:out value='${erreurs.erreurCocktail}' /></p>
		</div>
		<div>
			<label for="table">Numéro de table : </label>
			<input id="table" name="table" type="text" value="<c:out value="${param['table']}" />">
			<p class='erreur'><c:out value='${erreurs.erreurTable}' /></p>
		</div>
		<div>
			<button type="submit">Commander</button>
		</div>
		<div>
	  		<a href="<c:url value="/accueil"/>">Retour à l'accueil</a>  
		</div>
	</form>
  </div>
  </body>
</html>