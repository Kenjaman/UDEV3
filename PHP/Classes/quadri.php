<?php
use Symfony\Component\Finder\Finder;
use App\Rectangle;
require 'vendor/autoload.php';

//require_once 'Rectangle.php';
$rectangle = new Rectangle(3,4);
echo $rectangle->area();
echo $rectangle->perimeter();
echo $rectangle->type();

$finder = new Finder();
// find all files in the current directory
$finder->files()->in(__DIR__);
foreach ($finder as $file) {
    echo $absoluteFilePath = $file->getRealPath();
    echo "\n";
}