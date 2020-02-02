<?php
 //                    Pas utilisée !!!
session_start();
require_once 'FoodTruck.php';
$id = $_GET['id']??'';
/** @var FoodTruck $foodTruck */
$foodTruck= unserialize($_SESSION['foodtruck'][$id]);

if(isset($_POST['nom'])){
    $foodTruck->setNom($_POST['nom'])
        ->setAdresse($_POST['adresse'])
        ->setCuisine($_POST['cuisine']);
    $_SESSION['foodtruck'][$id] = serialize($foodTruck);
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
        <input name="nom" type="text" value="<?php echo $foodTruck->getNom();?>" required/><br>
        <label for="adresse">Adresse : </label>
        <input name="adresse" type="text" value="<?php echo $foodTruck->getAdresse();?>"/><br>
        <label for="cuisine">Cuisine : </label>
        <input name="cuisine" type="text" value="<?php echo $foodTruck->getCuisine();?>"/><br>
        <input type="submit" value="Envoyer"/>
    </form>
    </body>
    </html>

