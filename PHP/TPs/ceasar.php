<?php
define('DECALAGE', 2);
function caesar($lettre)
{
    $valeur = mb_ord($lettre);
    if($valeur >= 97 && $valeur<=122) {
        $valeur -= 97;
        $valeur += DECALAGE;
        $valeur %= 26;
        $valeur += 97;
    }elseif($valeur>=65 && $valeur<=90){
        $valeur -= 65;
        $valeur += DECALAGE;
        $valeur %= 26;
        $valeur += 65;
    }elseif ($valeur >= 48 && $valeur <=57){
        return ($lettre+10+DECALAGE)%10;
    }else{
        return mb_chr($valeur);
    }
    return mb_chr($valeur);
}

function dCaesar($lettre)
{
    $valeur = mb_ord($lettre);
    if($valeur >= 97 && $valeur<=122) {
        $valeur -= (97+26);
        $valeur -= DECALAGE;
        $valeur %= 26;
        $valeur += (97+26);
    }elseif($valeur>=65 && $valeur<=90){
        $valeur -= (65+26);
        $valeur -= DECALAGE;
        $valeur %= 26;
        $valeur += (65+26);
    }elseif ($valeur >= 48 && $valeur <=57){
        return ($lettre+10-DECALAGE)%10;
    }else{
        return mb_chr($valeur);
    }
    return mb_chr($valeur);
}

function sCaesar($string)
{
    $stringC = "";
    //$string = mb_str_split($string);
    for ($i = 0; $i < mb_strlen($string); $i++) {
        $stringC .= caesar($string[$i]);
    }
    return $stringC;
}

function dSCaesar($string)
{
    $stringC = "";
    //$string = mb_str_split($string);
    for ($i = 0; $i < mb_strlen($string); $i++) {
        $stringC .= dCaesar($string[$i]);
    }
    return $stringC;
}

