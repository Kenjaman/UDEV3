<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${etudiant1.fraisInsc > etudiant2.fraisInsc ? etudiant1.concat(etudiant1.prenom): etudiant2.nom} Paye le plus de frais d'inscription
</body>
</html>