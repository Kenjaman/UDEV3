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
	<h1>Formulaire de modification de l'animal <c:out value="${animal.id}"/></h1>
			<form:form servletRelativeAction="/animal/${animal.id}/modif" modelAttribute="animal">
			<form:input path="id" type="hidden"/>
				<p><form:label path="nom">Nom : </form:label><form:input path="nom"/>
				</p><form:errors path="nom"/>
				<p><form:label path="description">Description : </form:label><form:textarea path="description"/> </p>
				<p><form:label path="origine">Origine : <form:input path="origine"/></form:label></p>
				<p><form:label path="espece">Espèce : </form:label><form:select path="espece.id">
					<form:options items="${especes}" itemLabel="nom" itemValue="id"/>
				</form:select>
				<form:errors path="espece.id"></form:errors></p>
				<p><form:label path="regime">Regime: <form:select path="regime">
					<c:forEach items="${regimes}" var="regime">
						<form:option value="${regime}" label="${regime}"/>
					</c:forEach>
				</form:select></form:label></p>
				<button type="submit">Enregistrer</button>
			</form:form>
</body>
</html>