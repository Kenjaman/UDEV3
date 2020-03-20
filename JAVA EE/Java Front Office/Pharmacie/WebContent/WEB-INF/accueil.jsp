<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="client" items = "${clients}" >
${client.nom }

</c:forEach>

<c:forEach var="medoc" items = "${medicaments}" >

${medoc.nom }
${medoc.stock }
</c:forEach>
</body>
</html>