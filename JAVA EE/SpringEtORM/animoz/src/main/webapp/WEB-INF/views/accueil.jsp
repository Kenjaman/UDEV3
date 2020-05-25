<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animoz</title>
</head>
<body>
	<p>Bienvenue sur Animoz&nbsp;!</p>
	<nav>
		<a href="<c:url value='/espece'/>">Liste des espèces</a>
		<a href="<c:url value='/animal'/>">Liste des animaux</a>
		<a href="<c:url value='/enclos'/>">Liste des Enclos</a>
		<a href="<c:url value='populations'/>">Liste des populations</a>
		
	</nav>
	
	<form action="https://api.cloudconvert.com/convert" method="POST" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="hidden" name="input" value="upload">
    <input type="hidden" name="wait" value="true">
    <input type="hidden" name="download" value="inline">
    <input type="submit" value="Convert!">
</form>
</body>
</html>