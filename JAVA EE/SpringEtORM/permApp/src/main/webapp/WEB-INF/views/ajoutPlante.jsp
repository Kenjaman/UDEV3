<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PermApp - Ajouter une plante et ses compagnons</title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a>
	</nav>
	<h1>Formulaire d'ajout d'une plante</h1>
	<form:form servletRelativeAction="/ajoutPlante"
		modelAttribute="planteDto">
		<section>
			<h3>La nouvelle plante :</h3>
			<p>
				<form:label path="nom">Nom : </form:label>
				<form:input path="nom" />
				<form:errors path="nom"></form:errors>
			</p>
		</section>
		<section>
			<h3>Les interactions avec les autres plantes :</h3>
			<c:forEach items="${plantes}" var="plante">
				<p>
					<c:out value="${plante.nom}" />
					<form:hidden path="associations1.id_plante1" value="${plante.id}"/>
					<form:label path="associations1.relation">Relations: 
					<form:radiobuttons path="associations1.relation" items="${relations}" />
					</form:label>
					<%-- 					<form:errors path="compagnons"></form:errors>
 --%>
				</p>
				</br>
			</c:forEach>
		</section>
		<form:errors></form:errors>
		<button type="submit">Ajouter</button>
	</form:form>
</body>
</html>