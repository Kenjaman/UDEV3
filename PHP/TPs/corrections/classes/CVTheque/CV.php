<?php

class CV
{
    private string $id;
    private string $firstname;
    private string $lastname;
    private string $address;
    private string $primarySkill;
    private string $secondarySkill;
    // indique si c'est un nouveau CV
    private $new = false;

    public function __construct(
        $firstname,
        $lastname,
        $address,
        $primarySkill,
        $secondarySkill,
        $id = null
    )
    {
        if (empty($id)) {
            // nouveau CV
            $this->new = true;
            $this->id = uniqid();
        } else {
            // CV existant
            $this->id = $id;
        }
        $this->firstname = $firstname;
        $this->lastname = $lastname;
        $this->address = $address;
        $this->primarySkill = $primarySkill;
        $this->secondarySkill = $secondarySkill;
    }

    /**
     * @return int
     */
    public function getId(): string
    {
        return $this->id;
    }

    /**
     * @return string
     */
    public function getFirstname(): string
    {
        return $this->firstname;
    }

    /**
     * @param string $firstname
     * @return CV
     */
    public function setFirstname(string $firstname): CV
    {
        $this->firstname = $firstname;
        return $this;
    }

    /**
     * @return string
     */
    public function getLastname(): string
    {
        return $this->lastname;
    }

    /**
     * @param string $lastname
     * @return CV
     */
    public function setLastname(string $lastname): CV
    {
        $this->lastname = $lastname;
        return $this;
    }

    /**
     * @return string
     */
    public function getAddress(): string
    {
        return $this->address;
    }

    /**
     * @param string $address
     * @return CV
     */
    public function setAddress(string $address): CV
    {
        $this->address = $address;
        return $this;
    }

    /**
     * @return string
     */
    public function getPrimarySkill(): string
    {
        return $this->primarySkill;
    }

    /**
     * @param string $primarySkill
     * @return CV
     */
    public function setPrimarySkill(string $primarySkill): CV
    {
        $this->primarySkill = $primarySkill;
        return $this;
    }

    /**
     * @return string
     */
    public function getSecondarySkill(): string
    {
        return $this->secondarySkill;
    }

    /**
     * @param string $secondarySkill
     * @return CV
     */
    public function setSecondarySkill(string $secondarySkill): CV
    {
        $this->secondarySkill = $secondarySkill;
        return $this;
    }

    public function isNew(): bool
    {
        return $this->new;
    }

    public function saved()
    {
        $this->new = false;

        return $this;
    }

}
