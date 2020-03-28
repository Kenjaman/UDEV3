<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<c:forEach var="client" items = "${clients}" >
	<tr>
		<td>${client.nom }</td>
		<td>${client.credit}</td>		
	</tr>
	</c:forEach>
</table>
<table>
	
	<c:forEach var="medoc" items = "${medicaments}" >
	<tr>
		<td>${medoc.nom }</td>
		<td>${medoc.prix}</td>		
		<td>${medoc.stock}</td>		
	</tr>
	</c:forEach>
</table>
<a href="<c:url value="/appro"/>">Approvisionement</a>
<a href="<c:url value="/achat"/>">Achat</a>
</body>
</html>