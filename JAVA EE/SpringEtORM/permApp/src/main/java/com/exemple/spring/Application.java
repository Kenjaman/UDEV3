package com.exemple.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("file:application-context.xml");
		
		Voiture voiture = ctx.getBean("maVoiture", Voiture.class);
		
		System.out.println(voiture.getMarque());
		System.out.println(voiture.getMoteur().getNbSoupapes());
		
		ctx.close();

	}
}
