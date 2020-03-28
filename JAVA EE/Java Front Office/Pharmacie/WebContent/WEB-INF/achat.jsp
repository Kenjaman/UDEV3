<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<p style="color:red;">
	<c:out value="${error}" />
</p>
<body>
	<form method="POST" action="./achat">

		<label for="nomCli">Nom du client :<input name="nomCli"
			type="text" /></label>
		 <label for="nomMed">Nom du medoc :<input
			name="nomMed" type="text" /></label>
		 <label for="qte">Quantité :<input
			name="qte" type="number" /></label>
		 <label for="paiement">Prix payé
			:<input name="paiement" type="number" />
		</label>
		<button type="submit">Envoie</button>
	</form>
</body>
</html>