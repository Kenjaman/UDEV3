<?php
namespace App;
interface Polygone
{
    public function perimeter(): float;
    public function area(): float;
    public function type(): string;
}