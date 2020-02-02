<?php


class FoodTruck
{
    private string $uuid;
    private string $nom;
    private string $adresse;
    private string $cuisine;

    /**
     * FoodTruck constructor.
     * @param string $nom
     * @param string $adresse
     * @param string $cuisine
     */
    public function __construct(string $nom, string $adresse, string $cuisine)
    {
        $this->uuid=uniqid();
        $this->nom = $nom;
        $this->adresse = $adresse;
        $this->cuisine = $cuisine;
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
     * @return FoodTruck
     */
    public function setNom(string $nom): FoodTruck
    {
        $this->nom = $nom;
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
     * @return FoodTruck
     */
    public function setAdresse(string $adresse): FoodTruck
    {
        $this->adresse = $adresse;
        return $this;
    }

    /**
     * @return string
     */
    public function getCuisine(): string
    {
        return $this->cuisine;
    }

    /**
     * @param string $cuisine
     * @return FoodTruck
     */
    public function setCuisine(string $cuisine): FoodTruck
    {
        $this->cuisine = $cuisine;
        return $this;
    }

    /**
     * @return string
     */
    public function getUuid(): string
    {
        return $this->uuid;
    }


}