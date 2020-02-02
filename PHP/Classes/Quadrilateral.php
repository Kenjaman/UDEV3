<?php
namespace App;
use App\Polygone;
//require_once 'Polygone.php';

abstract class Quadrilateral implements Polygone
{
    protected float $side1;
    protected float $side2;
    protected float $side3;
    protected float $side4;


    public function __construct(float $side1, float $side2,
                                float $side3, float $side4)
    {
        $this->side1 = $side1;
        $this->side2 = $side2;
        $this->side3 = $side3;
        $this->side4 = $side4;
    }

    public function perimeter(): float
    {
        return $this->side1 + $this->side2 + $this->side3
            +$this->side4;
    }

    public abstract function area():float ;

}