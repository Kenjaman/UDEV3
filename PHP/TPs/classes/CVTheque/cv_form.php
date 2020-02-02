<?php
require_once 'CV.php';
/** @var CV $cv */
$cv = null;
$id = $_GET['id'] ?? '';
$nom = $_POST['nom'] ?? '';
$prenom = $_POST['prenom'] ?? '';
$adresse = $_POST['adresse'] ?? '';
$competenceP = $_POST['competenceP'] ?? '';
$competenceS = $_POST['competenceS'] ?? '';

if (!empty($nom) &&
    !empty($prenom) &&
    !empty($adresse) &&
    !empty($competenceP) &&
    !empty($competenceS)
) {
    $cv = new CV($nom, $prenom, $adresse, $competenceP, $competenceS);
    try {
        $conn = new PDO("mysql:host=localhost;dbname=CVTheque", "root");
        if (isset($_POST['id'])) {
            $sql = "UPDATE cv SET nom = :nom,
                     prenom = :prenom,
                      adresse = :adresse,
                       competenceP = :competenceP,
                        competenceS = :competenceS
                         WHERE id = :id";
        } else {
            $sql = "INSERT INTO CV (nom,prenom,adresse,competenceP,competenceS) 
VALUES (:nom,:prenom,:adresse,:competenceP,:competenceS)";
        }
        $prep = $conn->prepare($sql);
        $prep->bindParam(':id', $_POST['id']);
        $prep->bindParam(':nom', $nom);
        $prep->bindParam(':prenom', $prenom);
        $prep->bindParam(':adresse', $adresse);
        $prep->bindParam(':competenceP', $competenceP);
        $prep->bindParam(':competenceS', $competenceS);
        if ($prep->execute()) {
            echo "Nouveau CV dans la base";
            echo "<script>window.location='cv_list.php';</script>";
            exit;
        } else {
            echo "Error le cv ne s'est pas enregistrer <br>";
            print_r($prep->errorInfo());
        }
    } catch (PDOException $e) {
        echo "Connection failed:" . $e->getMessage();
    } finally {
        $conn = null;
    }
} elseif (!empty($id)) {
    try {
        $conn = new PDO("mysql:host=localhost;dbname=CVTheque", "root");
        $sql = "SELECT * FROM CV where id = :id";
        $prep = $conn->prepare($sql);
        $prep->bindParam(':id', $id);
        $prep->execute();
        $cvObj = $prep->fetch(PDO::FETCH_OBJ);
        $cv = new CV($cvObj->nom,
            $cvObj->prenom,
            $cvObj->adresse,
            $cvObj->competenceP,
            $cvObj->competenceS,
            $cvObj->id);
    } catch (PDOException $e) {
        echo "Connection failed:" . $e->getMessage();
    } finally {
        $conn = null;
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
<form method="POST" action="">
    <?php
    if (isset($cv)) {
        echo '<input name="id" type="hidden" value="' . $cv->getId() . '" />';
    }
    ?>
    <label for="nom">Nom :
        <input name="nom" type="text" value="<?php echo isset($cv) ? $cv->getNom() : ''; ?>" required/></label>
    <br>
    <label for="prenom">Prenom :
        <input name="prenom" type="text" value="<?php echo isset($cv) ? $cv->getPrenom() : ''; ?>" required/></label>
    <br>
    <label for="adresse">Adresse :
        <input name="adresse" type="text" value="<?php echo isset($cv) ? $cv->getAdresse() : ''; ?>"/> </label>
    <br>
    <label for="competenceP">Competence Primaire :
        <input name="competenceP" type="text" value="<?php echo isset($cv) ? $cv->getCompetenceP() : ''; ?>"/></label>
    <br>
    <label for="competenceS">Competence Secondaire :
        <input name="competenceS" type="text" value="<?php echo isset($cv) ? $cv->getCompetenceS() : ''; ?>"/> </label>
    <br>
    <input type="submit" value="Envoyer"/>
</form>
</body>
</html>
