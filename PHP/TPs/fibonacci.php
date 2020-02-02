<?php

function fibon(int $nb, &$tab)
{
    if(isset($tab[$nb]))
        return $tab[$nb];
    switch ($nb) {
        case 0:
            $tab[0] = 0;
            break;
        case 1:
            $tab[1] = 1;
            break;
        default:
            $tab[$nb] = fibon($nb - 2,$tab) + fibon($nb - 1,$tab);
    }
    return $tab[$nb];
}

$stdin = fopen('php://stdin', 'r');
$line = stream_get_line($stdin, 1024, PHP_EOL);
fibon($line,$tab);
print_r($tab);