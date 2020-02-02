<?php
require 'vendor/autoload.php';
use Michelf\Markdown;
use Michelf\MarkdownExtra;
?>

<form method="post" action="" xmlns="http://www.w3.org/1999/html">
    <textarea name="markdown" placeholder="Votre texte en Markdown" cols="100" rows="20"></textarea></br>
    <input type="submit" value="Parser" />
</form>
<?php

if(isset($_POST['markdown'])) {
    $_POST['markdown'].="\n ___";
    $my_html = Markdown::defaultTransform($_POST['markdown']);
    echo $my_html;
    //echo "<br />________________________________________________________________________________<br />";
    $my_html2 = MarkdownExtra::defaultTransform($_POST['markdown']);
    echo $my_html2;
}