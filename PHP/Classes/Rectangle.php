<?php
namespace App;
use App\Quadrilateral;
//require_once 'Quadrilateral.php';
class Rectangle extends Quadrilateral
{
    public function __construct(float $side1, float $side2)
    {
        parent::__construct($side1,$side2,$side1,$side2);
    }

    public function area(): float
    {
        return $this->side1 * $this->side2;
    }


    public function type(): string
    {
        return get_class();
    }
}