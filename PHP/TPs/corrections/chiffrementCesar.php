<?php
define('DECALAGE', 2);

$chaine = 'Voulez-vous un été à 29° ?';

$result = chiffrement($chaine, DECALAGE);

echo $result;

$chaineChiffre = 'Xqwngb-xqwu wp gvg c 41° ?';
$resultDechiffrement = dechiffrement($chaineChiffre, DECALAGE);

echo $resultDechiffrement;

function dechiffrement($chaine, $decalage)
{
    $result = '';
    // transformer la chaine en tableau de char
    $chars = mb_str_split_carlos($chaine);

    // iterer sur le tableau
    foreach ($chars as $char) {
        // chiffrer chaque caractère
        if (is_numeric($char)) {
            // on chiffre les caractères numériques
            // 2 -> 0 // 3 -> 1 // 0 -> 8 // 1 -> 9
            $result .= ($char - $decalage + 10) % 10;
        } else {
            $ord = ord($char);
            if ($ord >= 97 && $ord <= 122) {
                // on chiffre les minuscules
                $result .= chr(($ord - 97 - $decalage + 26) % 26 + 97);
            } elseif ($ord >= 65 && $ord <= 90) {
                // on chiffre les majuscules
                $result .= chr(($ord - 65 - $decalage + 26) % 26 + 65);
            } else {
                // on laisse à l'identique ce qu'on ne sait pas chiffrer
                $result .= $char;
            }
        }
    }

    return $result;
}

function chiffrement($chaine, $decalage)
{
    $result = '';

    // on retire les accents
    // $chaine = iconv('UTF-8', 'ASCII//TRANSLIT//IGNORE', $chaine);
    // $chaine = strtr($chaine,'àáâãäçèéêëìíîïñòóôõöùúûüýÿÀÁÂÃÄÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝ','aaaaaceeeeiiiinooooouuuuyyAAAAACEEEEIIIINOOOOOUUUUY');
    $chaine = strtr($chaine, ["à" => "a", "é" => "e"]);
    // transformer la chaine en tableau de char
    $chars = mb_str_split_carlos($chaine);

    // iterer sur le tableau
    foreach ($chars as $char) {
        // chiffrer chaque caractère
        if (is_numeric($char)) {
            // on chiffre les caractères numériques
            // 0 -> 2 // 1 -> 3 // 8 -> 0 // 9 -> 1
            $result .= ($char + $decalage) % 10;
        } else {
            $ord = ord($char);
            if ($ord >= 97 && $ord <= 122) {
                // on chiffre les minuscules
                $result .= chr(($ord - 97 + $decalage) % 26 + 97);
            } elseif ($ord >= 65 && $ord <= 90) {
                // on chiffre les majuscules
                $result .= chr(($ord - 65 + $decalage) % 26 + 65);
            } else {
                // on laisse à l'identique ce qu'on ne sait pas chiffrer
                $result .= $char;
            }
        }
    }

    return $result;
}

function mb_str_split_carlos(string $chaine): array
{
    $result = [];
    $length = mb_strlen($chaine);
    for ($i = 0; $i < $length; ++$i) {
        $result[] = mb_substr($chaine, $i, 1);
    }

    return $result;
}



