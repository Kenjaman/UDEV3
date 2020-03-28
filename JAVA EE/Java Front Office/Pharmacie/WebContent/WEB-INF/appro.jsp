<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${!empty error }">
<p style="color: red;">
	<c:out value="${error}" />
<form method="PUT" action="">
	<label for="create">Voulez vous le créer ? <input type="radio"
		name="create" value="1">oui </input> <input type="number" name="prix" placeholder="le prix ?"/> <input type="radio" name="create"
		value="0">non</input>
	</label>
	<button type="submit">Valider</button>
</form>
</p>
</c:if>
<body>
	<form method="POST" action="./appro">
		<label for="nomMed">Nom du medoc :<input name="nomMed"
			type="text" /></label> <label for="qte">Quantité :<input name="qte"
			type="number" /></label>
		<button type="submit">Envoie</button>
	</form>
</body>
</html>