<?php
session_start();
require_once 'FoodTruck.php';

$search = $_GET['search'] ?? '';
/** @var FoodTruck[] $foodtrucks */
$foodtrucks = getFoodTrucks($search);

function getFoodTrucks($search): array
{
    $foodTrucks = [];
    foreach ($_SESSION['foodtruck'] as $sfoodTruck) {
        if ($search && stripos($sfoodTruck, $search) === false) {
            continue;
        }
        $foodTrucks[] = unserialize($sfoodTruck);
    }
    return $foodTrucks;
}

?>
<html>
<head></head>
<body>
<form method="get">
    <input placeholder="Recherche" name="search" value="<?php echo $search; ?>">
    <input type="submit" value="Recherche">
</form>
<h1>Liste de tous les food trucks de Bordeaux</h1>
<?php
foreach ($foodtrucks as $foodTruck) {
    echo '<div>';
    echo '<h2>' . $foodTruck->getNom() . '</h2>';
    echo '<small>' . $foodTruck->getCuisine() . '</small><br>';
    echo 'Vous pouvez nous trouver ' . $foodTruck->getAdresse();
    echo '<a href=FoodTruckBordeaux.php?id='.$foodTruck->getUuid().'>Modifier</a>';
    echo '</div>';
}
?>
<a href="FoodTruckBordeaux.php">Ajouter un food truck</a>
</body>
</html>
