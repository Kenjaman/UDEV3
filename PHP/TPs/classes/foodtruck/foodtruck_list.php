<?php
session_start();
require_once 'FoodTruck.php';
//require_once 'C:\Users\kenan.roux\Documents\DevEPSI\UDEV3\PHP\TPs\destructionSession.php';

$recherche=$_GET['recherche']??'';
/** @var FoodTruck[] $foodTrucks */
$foodTrucks=getFoodTrucks($recherche)??[];

function getFoodTrucks(string $recherche=null)
{
    $foodTrucks=[];
    if(isset($_SESSION['foodtruck'])){
        foreach ($_SESSION['foodtruck'] as $sfoodTruck) {
            $sfoodTruck=unserialize($sfoodTruck);
            if(!empty($recherche)){
                if (strncasecmp($recherche, $sfoodTruck->getNom(),strlen( $sfoodTruck->getNom())/2) !== 0)
                   continue;
            }
            $foodTrucks[] = $sfoodTruck ;
        }
    }
    return $foodTrucks;
}

?>

<html>
<h1>Liste des Food Trucks</h1>
<a href="foodtruckpage.php">Ajouter un FoodTruck</a>
    <?php
    foreach ($foodTrucks as $foodTruck){
        echo "<div><ul>";
        echo "<li> Nom :".$foodTruck->getNom()."</li>";
        echo "<li> Retrouvez nous ici :".$foodTruck->getAdresse()."</li>";
        echo "<li> Notre cuisine :".$foodTruck->getCuisine()."</li>";
        echo '<a href="foodTruckpage.php?id='.$foodTruck->getUuid().'">Modifier</a>';
        echo "</ul></div>";
    }
    if(empty($foodTrucks))
        echo "<h3>Aucun FoodTruck trouvé</h3>"?>

<form method="get" action="">
    <label for="recherche">Rechercher FoodTruck :</label>
    <input type="search" name="recherche" placeholder="Nom recherché"/>
    <input type="submit" value="Rechercher" />
</form>

</html>
