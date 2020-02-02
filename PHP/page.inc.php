<?php
$_SESSION['city'] = 'Bordeaux';
$city = $_SESSION['city'];
echo "<p>Bonjour $city</p>";
session_destroy(); // cela va supprimer la session
$_SESSION = []; // on vide les données de session
var_dump($_SESSION); // les données ne sont plus là
?>