<?php
require_once 'CV.php';
/** @var CV[] $cvs */
$cvs=[];
try{
    $conn = new PDO("mysql:host=localhost;dbname=CVTheque","root");
    $sql = "SELECT * FROM CV";
    $prep = $conn->prepare($sql);

    $prep->execute();
    $cvsObj = $prep->fetchAll(PDO::FETCH_OBJ);
    foreach ($cvsObj as $cvObj){
        $cvs[]=new CV($cvObj->nom,
            $cvObj->prenom,
            $cvObj->adresse,
            $cvObj->competenceP,
            $cvObj->competenceS,
            $cvObj->id);
    }
}catch (PDOException $e){
    echo "Connection failed:".$e->getMessage();
} finally {
    $conn = null;
}
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Les CVs de la base :</h3>
<div>
    <?php
    foreach ($cvs as $cv){
        echo '<ul>';
        echo '<li>Nom : '.$cv->getNom().'</li>';
        echo '<li>Prenom : '.$cv->getPrenom().'</li>';
        echo '<li>Adresse : '.$cv->getAdresse().'</li>';
        echo '<li>Competence Primaire : '.$cv->getCompetenceP().'</li>';
        echo '<li>Competence Secondaire : '.$cv->getCompetenceS().'</li>';
        echo '<li><a href="cv_form.php?id='.$cv->getId().'">Modifier</a>';
        echo '</ul>';
    }?>
</div>
</body>
</html>
