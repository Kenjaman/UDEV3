<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz - Déclaration d'une population</title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a>
	</nav>
	<h1>Formulaire de déclaration d'une population d'animaux</h1>
			<form:form servletRelativeAction="/ajoutPopulation" modelAttribute="population">
				<p><form:label path="animal.id">Animal : </form:label>
				<form:select path="animal.id">
					<form:options items="${animaux}" itemLabel="nom" itemValue="id"/>
				</form:select>
				<form:errors path="animal"></form:errors></p>
				<p><form:label path="nombreIndividus">Nombre d'individus : </form:label>
				<form:input type="number" min="1" path="nombreIndividus"/></p>
				<p><form:label path="enclos.id">Numéro de l'enclos : </form:label>
					<form:select path="enclos.id">
						<form:options items="${enclos}" itemLabel="numero" itemValue="id"/>
					</form:select><form:errors path="*" ></form:errors>
				</p>
				<button type="submit">Ajouter</button>
				
			</form:form>
</body>
</html>