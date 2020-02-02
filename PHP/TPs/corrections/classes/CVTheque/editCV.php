<?php
require_once 'CV.php';
require_once 'Db.php';

$db = new Db();

$firstname = $_POST['firstname'] ?? '';
$lastname = $_POST['lastname'] ?? '';
$address = $_POST['address'] ?? '';
$primarySkill = $_POST['primary_skill'] ?? '';
$secondarySkill = $_POST['secondary_skill'] ?? '';

if (
    !empty($firstname)
    && !empty($lastname)
    && !empty($address)
    && !empty($primarySkill)
    && !empty($secondarySkill)
) {
    $cv = new CV(
        $firstname,
        $lastname,
        $address,
        $primarySkill,
        $secondarySkill
    );
    $db->saveCV($cv);
    var_dump($cv);
}
?>
<html>
<head>

</head>
<body>
<form method="post">
    <label>Prénom : </label>
    <input name="firstname"><br>
    <label>Nom : </label>
    <input name="lastname"><br>
    <label>Adresse : </label>
    <input name="address"><br>
    <label>Compétence Primaire : </label>
    <input name="primary_skill"><br>
    <label>Compétence Secondaire : </label>
    <input name="secondary_skill"><br>
    <br>
    <input type="submit" value="Envoyer">
</form>

<?php
if ($cv) {
    echo '<a href="showCV.php?id='.$cv->getId().'">show CV</a>';
}
?>
</body>
</html>
