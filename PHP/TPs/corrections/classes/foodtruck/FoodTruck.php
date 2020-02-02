<?php


class FoodTruck
{
    private string $uuid;
    private string $nom;
    private string $adresse;
    private string $cuisine;

    public function __construct($nom, $adresse, $cuisine)
    {
        $this->uuid = uniqid();

        $this->nom = $nom;
        $this->adresse = $adresse;
        $this->cuisine = $cuisine;
    }

    public function getUuid()
    {
        return $this->uuid;
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
}
