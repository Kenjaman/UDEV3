<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz - <c:out value="${animal.nom}" /></title>
</head>
<body>
	<nav>
		<a href="<c:url value='/'/>">Accueil</a> <a
			href="<c:url value='/ajoutPopulation'/>">Déclarer une population</a>
	</nav>
	<table>
		<tr>
			<th>Numéro d'enclos</th>
			<th>Espèces présentes</th>
			<th>Population totale</th>
		</tr>
		<c:forEach items="${enclos}" var="enclo">
			<tr>
				<td><c:out value="${enclo.numero}" /></td>
				<td>
					<ul><c:set var="nb" value="0"></c:set>
						<c:forEach items="${enclo.populations}" var="population">
							<li><c:out value="${population.nombreIndividus}" />&nbsp;<c:out value="${population.animal.nom}" /> </li>
							<c:set var="nb" value="${nb+population.nombreIndividus}"></c:set>
						</c:forEach>
					</ul>
				<td>
					<c:out value="${nb}"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>