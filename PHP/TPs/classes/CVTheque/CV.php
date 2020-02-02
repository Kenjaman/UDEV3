<?php
class CV{
    private ?int $id;
    private string $nom;
    private string $prenom;
    private string $adresse;
    private string $competenceP;
    private string $competenceS;

    /**
     * CV constructor.
     * @param int $id
     * @param string $nom
     * @param string $prenom
     * @param string $adresse
     * @param string $competenceP
     * @param string $competenceS
     */
    public function __construct(string $nom, string $prenom, string $adresse, string $competenceP, string $competenceS, ?int $id = null)
    {
        if(!empty($id)) {
            $this->id = $id;
        }else
            $this->id = null;
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->adresse = $adresse;
        $this->competenceP = $competenceP;
        $this->competenceS = $competenceS;
    }

    /**
     * @return int
     */
    public function getId(): int
    {
        return $this->id;
    }

    /**
     * @return string
     */
    public function getNom(): string
    {
        return $this->nom;
    }

    /**
     * @param string $nom
     * @return CV
     */
    public function setNom(string $nom): CV
    {
        $this->nom = $nom;
        return $this;
    }

    /**
     * @return string
     */
    public function getPrenom(): string
    {
        return $this->prenom;
    }

    /**
     * @param string $prenom
     * @return CV
     */
    public function setPrenom(string $prenom): CV
    {
        $this->prenom = $prenom;
        return $this;
    }

    /**
     * @return string
     */
    public function getAdresse(): string
    {
        return $this->adresse;
    }

    /**
     * @param string $adresse
     * @return CV
     */
    public function setAdresse(string $adresse): CV
    {
        $this->adresse = $adresse;
        return $this;
    }

    /**
     * @return string
     */
    public function getCompetenceP(): string
    {
        return $this->competenceP;
    }

    /**
     * @param string $competenceP
     * @return CV
     */
    public function setCompetenceP(string $competenceP): CV
    {
        $this->competenceP = $competenceP;
        return $this;
    }

    /**
     * @return string
     */
    public function getCompetenceS(): string
    {
        return $this->competenceS;
    }

    /**
     * @param string $competenceS
     * @return CV
     */
    public function setCompetenceS(string $competenceS): CV
    {
        $this->competenceS = $competenceS;
        return $this;
    }




}