<?php
require_once 'CV.php';

class Db
{
    /** @var PDO */
    private $conn;

    function connect()
    {
        if (isset($this->conn)) {
            return;
        }
        try {
            $this->conn = new PDO("mysql:host=localhost;port=3306;dbname=cvtheque", 'symfony', 'symfony');
        } catch (PDOException $e) {
            echo "Connection failed: " . $e->getMessage();
        }
    }

    function saveCV(CV $cv)
    {
        // on se connecte à la DB
        $this->connect();
        // soit nouveau CV -> INSERT
        if ($cv->isNew()) {
            $sql = "INSERT INTO cv (id, firstname, lastname, address, primary_skill, secondary_skill)
    VALUES (:id, :firstname, :lastname, :address, :primary_skill, :secondary_skill)";
            $prep = $this->conn->prepare($sql);
            $prep->bindValue(':id', $cv->getId());
            $prep->bindValue(':firstname', $cv->getFirstname());
            $prep->bindValue(':lastname', $cv->getLastname());
            $prep->bindValue(':address', $cv->getAddress());
            $prep->bindValue(':primary_skill', $cv->getPrimarySkill());
            $prep->bindValue(':secondary_skill', $cv->getSecondarySkill());
            $prep->execute();

            // on indique que le CV a été enregistré en BDD
            $cv->saved();
        } else {
            // soit CV existant -> UPDATE
            throw new Exception('on ne gère pas encore les màj de CV');
        }

        // on ferme la connexion
        $this->conn = null;
    }

    public function findCV(string $id): ?CV
    {
        if (empty($id)) {
            return null;
        }
        // on recherche le CV en BDD
        $this->connect();
        $sql = "SELECT * FROM cv where id=:id";
        $prep = $this->conn->prepare($sql);
        $prep->bindValue(':id', $id);
        $prep->execute();
        $cvTab = $prep->fetchAll(PDO::FETCH_OBJ);

        if (empty($cvTab)) {
            // aucun cv n'a été trouvé
            return null;
        }

        // on hydrate le premier CV trouvé
        return new CV(
            $cvTab[0]->firstname,
            $cvTab[0]->lastname,
            $cvTab[0]->address,
            $cvTab[0]->primary_skill,
            $cvTab[0]->secondary_skill,
            $cvTab[0]->id
        );
    }
}
