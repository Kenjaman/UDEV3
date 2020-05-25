package com.animoz.modele;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class EnclosTest {
	
	private List<IPopulation> newPopulationList(int... nbIndividus) {
        List<IPopulation> populations = new ArrayList<>();
       
        for(int nb : nbIndividus) {
            IPopulation item = mock(IPopulation.class);
           
            when(item.getNombreIndividus()).thenReturn(nb);
            populations.add(item);           
        }
        return populations;
    }
	
	@Test
	void testEnclosCapaciteInitial() {
		Enclos test = new Enclos();
		
		assertEquals(0, test.getCapaciteMax());
		assertEquals(0, test.getCapaciteRestante());
	}
	
	@Test
	void testEnclosCapaciteUsuelle() {
		Enclos test = new Enclos();
		
		test.setCapaciteMax(20);
		assertEquals(20, test.getCapaciteMax());
		assertEquals(20, test.getCapaciteRestante());
	}
	
	@Test
	void testEnclosCapaciteErreur() {
		Enclos test = new Enclos();
		
		assertThrows(IllegalArgumentException.class , () -> test.setCapaciteMax(-10));
	}
	
	@Test
	
	void testEnclosEntreeDePopulation() {
		Enclos test = new Enclos();
		test.setCapaciteMax(20);
		List<IPopulation> listPopTest = newPopulationList(20);
		
		
		test.setPopulations(listPopTest);
		
		assertEquals(0, test.getCapaciteRestante());
		assertEquals(20, IPopulation.getTotalIndividus(listPopTest));
		
	}
	@Test
	void testEnclosEntreeDe2Population() {
		Enclos test = new Enclos();
		test.setCapaciteMax(20);
		List<IPopulation> listPopTest = newPopulationList(10,8);
		
		
		test.setPopulations(listPopTest);
		
		assertEquals(2, test.getCapaciteRestante());
		assertEquals(18, IPopulation.getTotalIndividus(listPopTest));
		
	}
	
	@Test
	
	void testErreurEnclosTropPetit() {
		Enclos test=new Enclos();
		List<IPopulation> listPop = newPopulationList(20);
		
		assertThrows(IllegalStateException.class, ()->test.setPopulations(listPop));
	}

	@Test
	
	void testSetCapaciteMaxInferieurAPopulation() {
		Enclos test = new Enclos();
		test.setCapaciteMax(20);
		List<IPopulation> listPop = newPopulationList(20);
		test.setPopulations(listPop);
		
		assertThrows(IllegalStateException.class,()->test.setCapaciteMax(10));
		
		
	}
	
}
