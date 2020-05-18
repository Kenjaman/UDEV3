<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz - Liste des espèces</title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a>
	</nav>
	<h1>Formulaire d'ajout d'un animal</h1>
			<form:form servletRelativeAction="/ajoutAnimal" modelAttribute="animalDto">
				<p><form:label path="nom">Nom : </form:label><form:input path="nom"/>
				<form:errors path="nom"></form:errors></p>
				<p><form:label path="description">Description : </form:label><form:textarea path="description"/> </p>
				<p><form:label path="origine">Origine : <form:input path="origine"/></form:label></p>
				<p><form:label path="espece">Espèce : </form:label>
				<form:select path="espece.id">
					<form:options items="${especes}" itemLabel="nom" itemValue="id"/>
				</form:select>
				<form:errors path="espece.id"></form:errors></p>
				<p>
				<form:label path="regime">Regime: 
					<form:select path="regime">
						<form:options items="${regimes}"/>
					</form:select>
				</form:label>
				<form:errors path="regime"></form:errors></p>
				<form:errors ></form:errors>
				<button type="submit">Ajouter</button>
			</form:form>
</body>
</html>