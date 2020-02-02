<form method="GET" action="ceasarPage.php">
    <label for="phrase">A chiffrer </label>
    <input type="text" name="phrase"/>
    <label for="de_phrase">A déchiffrer </label>
    <input type="text" name="de_phrase"/>
    <input type="submit" value="Envoyer"/>
</form>

<?php
require_once 'ceasar.php';

    if(isset($_GET["phrase"]) && $_GET["phrase"]!==''){
        echo sCaesar($_GET["phrase"]);
    }
    elseif (isset($_GET["de_phrase"]) && $_GET["de_phrase"] !==''){
        echo dSCaesar($_GET["de_phrase"]);
    }
