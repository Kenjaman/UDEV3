<?php
session_start();
$_SESSION ?? $_SESSION = ['blagues' => []];
$blagues = $_SESSION['blagues'];
if(isset($_COOKIE))
    $countBlagues = unserialize($_COOKIE['countBlagues']) ?? [];

$blague = $_POST['blague'] ?? '';
if (!empty($blague)) {
    $_SESSION['blagues'][md5($blague)] = $blague;
}
$idBlague = $viewBlague = '';
$showBlague = $_GET['show'] ?? 'no';
switch ($showBlague) {
    case 'no':
        break;
    case 'random':
        $idBlague = array_rand($blagues);
        $viewBlague = $blagues[$idBlague];
        break;

}
if (!empty($idBlague)) {
    $countBlagues[$idBlague] ?? $countBlagues[$idBlague] = 0;

    ++$countBlagues[$idBlague];
}
setcookie('countBlagues', serialize($countBlagues));
?>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form method="post">
        <label>Écrivez une blague</label>
        <input name="blague" />
        <input type="submit" value="Envoyer">
    </form>
    <a href="/PHP/TPs/corrections/blagueJoker.php?show=random">Afficher une blague au hasard</a>
    <?php
    if (!empty($viewBlague)) {
        echo '<pre>'.$viewBlague.'</pre>';
    }
    ?>
    <a href="/PHP/TPs/corrections/blagueJoker.php?show=all">Afficher toutes les blagues</a>
<pre>
    <?php
    if ($showBlague == 'all') {
        foreach ($blagues as $idBlague => $blague) {
            echo '<pre>';
            echo $blague;
            echo '</pre>';
            $count = $countBlagues[$idBlague] ?? 0;
            echo 'Cette blague a été affichée '.$count.' fois';
        }
    }
    ?>
</pre>
</body>
</html>
