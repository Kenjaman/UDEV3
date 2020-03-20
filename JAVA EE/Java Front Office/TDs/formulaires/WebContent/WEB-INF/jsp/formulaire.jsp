<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire</title>
</head>
<body>
	<form action="information.jsp" method="post">
		<div>
		<label for="nom">Nom</label>
		<input type="text" name="nom">
		</div>
		<div>
		<label for="prenom">Prénom</label>
		<input type="text" name="prenom">
		</div>
		<div>
		<label for="metier">Métier</label>
		<select name = "metiers"
		    multiple = "multiple"
		    size = "4">
		   <option value = "Ingénieur">Ingénieur</option>
		   <option value = "Téchnicien">Téchnicien </option>
		   <option value = "RH">RH</option>
		   <option value = "Secrétaire">Secrétaire</option>
	  </select>
	  </div>
	  <div>
  	<label for="liste-metiers">Autres métiers</label>
	<textarea name="liste-metiers" placeholder="Ex: Formateur, Enseignant"></textarea>
	 </div>
	 <div> 
	  <button type="submit">Valider</button>
	  <button type="reset">Annuler</button>
	 </div>	
	</form>
</body>
</html>