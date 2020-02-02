<?php
echo "Bonjour Bordeaux \n";
/*
echo '<br>';
$today = new DateTime();
var_dump($today);
echo '<br>';
$tomorrow = $today;
$tomorrow->add(new DateInterval('P1D'));
var_dump($tomorrow);
echo '<br>';
var_dump($today);
var_dump(isset($newVar));
$newVar = "hello";
var_dump(isset($newVar));

//HEREDOC
$longueVar=<<<Kenan
Coucou
Ceci 
Est une chaine 
Sur 
Plusieur lignes
Kenan;

echo $longueVar;
//HEREDOC -fin
echo '<br>';

$kmFait = 0;
$kmNantesBordeaux = 347;
for ($i = 0; $i < $kmNantesBordeaux; ++$i) {
    if (!$i) {
        continue; // on passe à l'itération suivante
    }
    echo "km parcourus sont de $i km \n ";
}
function stripAccents(?string $stripAccents) // on accepte  les string et NULL
{
// on n'affiche rien. On retourne une valeur à la place
    return iconv('UTF-8', 'ASCII//TRANSLIT//IGNORE',
        $stripAccents);
}
echo stripAccents('un éléphant');
*/
try {
// on envoie une exception
    throw new LogicException('où est la logique ?');
} catch (LogicException $e) {
    echo 'Oups ! une erreur';
    echo $e->getMessage();
} catch (Exception $e) {
    echo $e->getMessage();
} finally {
    echo 'ici, c\'est finally !';
}

$where = 'Bordeaux';
$closure = function ($who) use ($where) {
    echo sprintf('%s is in %s', $who, $where);
};
$closure('Carlos');