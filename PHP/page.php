<?php session_start();?>
<html>
    <head>
        <title>Formation PHP</title>
    </head>
    <body>
    <p>Bulululup</p>
    <form action="page.php" method="post">
        <input type="text" name="city" id="city" required>
        <input type="submit" value="Go !">
    </form>
    <?php
    require_once 'page.inc.php';
    ?>
    </body>
</html>
