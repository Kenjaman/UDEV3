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
	<ul>
		<c:forEach items="${especes}" var="espece">
			<li><c:out value="${espece.nom}"/></li>
		</c:forEach>
		<li>
			<form:form servletRelativeAction="/espece" modelAttribute="especeDto">
				<form:input path="nom"/> <button type="submit">Ajouter</button>
				<form:errors path="nom"/>
			</form:form>
		</li>
	</ul>
	<div><c:out value="${messageErreur}"/></div>
	<form:form servletRelativeAction="/espece/disparition" modelAttribute="especeDto">
		<form:select path="nom">
			<form:options items="${especes}" itemLabel="nom" itemValue="nom"/>
		</form:select>
		<button type="submit">Supprimer</button>
	</form:form>
</body>
</html>