<?php
session_start();
$_SESSION['foodtruck'] = $_SESSION['foodtruck'] ?? [];
require_once 'FoodTruck.php';

$nom = $_POST['nom'] ?? '';
$adresse = $_POST['adresse'] ?? '';
$cuisine = $_POST['cuisine'] ?? '';
$id = $_GET['id'] ?? '';
if (empty($id)) {
    if (!empty($nom) &&
        !empty($adresse) &&
        !empty($cuisine)) {
        $foodTruck = new FoodTruck($nom, $adresse, $cuisine);
        $_SESSION['foodtruck'][$foodTruck->getUuid()] = serialize($foodTruck);
        unset($foodTruck);
    }
} else {
    /** @var FoodTruck $foodTruck */
    $foodTruck = unserialize($_SESSION['foodtruck'][$id]);
    if (!empty($nom)) {
        $foodTruck->setNom($nom)
            ->setAdresse($adresse)
            ->setCuisine($cuisine);
        $_SESSION['foodtruck'][$id] = serialize($foodTruck);
    }
}

?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="foodtruck_list.php">Les foodTrucks</a>
<form method="POST" action="">
    <label for="nom">Nom : </label>
    <input name="nom" type="text" value="<?php echo isset($foodTruck) ? $foodTruck->getNom() : ''; ?>" required/><br>
    <label for="adresse">Adresse : </label>
    <input name="adresse" type="text" value="<?php echo isset($foodTruck) ? $foodTruck->getAdresse() : ''; ?>"/><br>
    <label for="cuisine">Cuisine : </label>
    <input name="cuisine" type="text" value="<?php echo isset($foodTruck) ? $foodTruck->getCuisine() : ''; ?>"/><br>
    <input type="submit" value="Envoyer"/>
</form>
</body>
</html>