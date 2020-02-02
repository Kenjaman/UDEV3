<?php
try {
    $conn = new
    PDO("mysql:host=localhost;dbname=formation_php",
        'root');
    $sql = "SELECT * FROM polygone";
    $prep = $conn->prepare($sql);
    $prep->execute();
    $polygones = $prep->fetchAll(PDO::FETCH_OBJ);
    print_r($polygones[2]->type);
} catch(PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
} finally {
    $conn = null;
}
