<?php
session_start();
$_SESSION ?? $_SESSION = ['blagues' =>[]];
$blague = $_POST["blague"] ?? '';
$lesBlagues=$_SESSION["blagues"]??'';
$countBlagues = unserialize($_COOKIE['countBlagues']) ?? [];

if(!empty($blague)) {
    $_SESSION['blagues'][md5($blague)]=$blague;
}
$idBlague=$viewBlague ='';
$showBlague = $_GET['show'] ?? 'no';
switch ($showBlague){
    case 'no':
        break;
    case 'random':
        if(!empty($lesBlagues)) {
            $idBlague = array_rand($lesBlagues);
            $viewBlague = $lesBlagues[$idBlague];
        }
        break;
    case 'supprimer':
        session_destroy();
        $_SESSION['blagues']='';
        break;
}
if (!empty($idBlague)) {
    $countBlagues[$idBlague] ?? $countBlagues[$idBlague] = 0;
    ++$countBlagues[$idBlague];
}
setcookie('countBlagues', serialize($countBlagues));
?>
<html>
<head><meta charset="UTF-8" />
</head>
<body>
<form method="POST" action="">
    <input type='text' name="blague" placeholder="Entres ta blague" required/>
    <input type="submit" value="Envois ta blague" />
</form>

<button onclick="location.href='blagues.php?show=random'">Blague au hasard</button>
<?php
if(!empty($viewBlague)){
    echo '<pre>'.$viewBlague.'</pre>';
}
?>
<button onclick="location.href='blagues.php?show=all'">Afficher toutes les blagues</button>
<button onclick="location.href='blagues.php?show=supprimer'">Supprimer la session</button>
<pre>
        <?php
        if($showBlague=="all" && !empty($lesBlagues)){
            echo "<ul>";
            foreach ($lesBlagues as $idBlague => $blague){
                echo "<li><pre>".$blague."</pre>";
                $count=$countBlague[$idBlague]??0;
                echo 'Afficher '.$count.' fois </li>';
            }
            echo "</ul>";
        }
        ?>
    </pre>
</body>
</html>