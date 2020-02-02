<?php
session_start();
$_SESSION['foodtruck'] = $_SESSION['foodtruck'] ?? [];

require_once 'FoodTruck.php';

$id = $_GET['id'] ?? '';
$nom = $_POST['nom'] ?? '';
$adresse = $_POST['adresse'] ?? '';
$cuisine = $_POST['cuisine'] ?? '';
if (empty($id)) {
    if (
        !empty($nom) &&
        !empty($adresse) &&
        !empty($cuisine)
    ) {
        $foodtruck = new FoodTruck($nom, $adresse, $cuisine);
        $_SESSION['foodtruck'][$foodtruck->getUuid()] = serialize($foodtruck);
    }
    $nom = '';
    $adresse = '';
    $cuisine = '';
} else {
    if (empty($_SESSION['foodtruck'][$id])) {
        throw new HttpException('Pas de foodtruck trouvé pour l\'id ' . $id);
    }
    /** @var FoodTruck $foodtruck */
    $foodtruck = unserialize($_SESSION['foodtruck'][$id]);
    if (
        !empty($nom) &&
        !empty($adresse) &&
        !empty($cuisine)
    ) {
        $foodtruck
            ->setNom($nom)
            ->setAdresse($adresse)
            ->setCuisine($cuisine);
        $_SESSION['foodtruck'][$foodtruck->getUuid()] = serialize($foodtruck);
    }
    $nom = $foodtruck->getNom();
    $adresse = $foodtruck->getAdresse();
    $cuisine = $foodtruck->getCuisine();
}
?>
<html>
<head></head>
<body>
<form method="post" action="FoodTruckBordeaux.php<?php if (!empty($id)) echo '?id=' . $id; ?>">
    <label>nom : </label>
    <input name="nom" value="<?php echo $nom; ?>" required><br>
    <label>adresse : </label>
    <input name="adresse" value="<?php echo $adresse; ?>" required><br>
    <label>cuisine : </label>
    <input name="cuisine" value="<?php echo $cuisine; ?>" required><br>
    <input type="submit" value="Envoyer">
</form>
<a href="listFoodTruckBordeaux.php">Liste de tous les food trucks de Bordeaux</a>
</body>
</html>
