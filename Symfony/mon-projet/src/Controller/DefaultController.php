<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Response;

class DefaultController extends AbstractController
{
    /**
     * @Route("/default", name="default_index")
     */
    public function index()
    {
        die("<h1>Hello world</h1>");
        /*
        return $this->render('default/index.html.twig', [
            'controller_name' => 'DefaultController',
        ]);
        */
    }

   /**
     * @Route("/", name="default_home")
     */
    public function home()
    {
    	$str = "<h2> OLA</h2>";
    	//echo $str;
    	return new Response($str);
        
    }
}
