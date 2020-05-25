package com.animalFood.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import com.animalFood.utils.IDate;
import com.animalFood.utils.SysDate;

class MovementTest {

	private final static Date MA_DATE = new GregorianCalendar(2020,Calendar.APRIL,10,9,0).getTime();
	
	private Movement newMovement(int qte) {
		IDate mockDate = mock(IDate.class);
		when(mockDate.getNow()).thenReturn(MA_DATE);
		IStockItem mockItem = mock(IStockItem.class);
		
		return new Movement(mockItem, qte, mockDate);
	}


	@Test
	void testMovementReplenish() {
		//Arrange
		IDate mockDate = mock(IDate.class);
		when(mockDate.getNow()).thenReturn(MA_DATE);
		IStockItem mockItem = mock(IStockItem.class);
		//Act
		Movement test = new Movement(mockItem, 3, mockDate);
		//Assert
		assertTrue(test.isReplenish());
		assertFalse(test.isRemove());
		assertEquals(MA_DATE,test.getDate());
		assertEquals(mockItem,test.getFood());
	}

	@Test
	void testMovementRemove() {
		//Arrange
		IDate mockDate = mock(IDate.class);
		when(mockDate.getNow()).thenReturn(MA_DATE);
		IStockItem mockItem = mock(IStockItem.class);
		//Act
		Movement test = new Movement(mockItem, -3, mockDate);
		//Assert
		assertFalse(test.isReplenish());
		assertTrue(test.isRemove());
		assertEquals(MA_DATE,test.getDate());
		assertEquals(mockItem,test.getFood());
	}

	@Test
	void testReplenishWith0() {
		Movement mov = newMovement(0);

		mov.apply();
		
		//assert
		assertTrue(mov.isReplenish());
		assertFalse(mov.isRemove());
		assertEquals(MA_DATE,mov.getDate());
	}
	
	@Test
	void testReplenishWithNull() {
		IDate myDate = mock(IDate.class);
		
		assertThrows(NullPointerException.class,() -> new Movement(null, 2, myDate));
	}

	@Test
	void testApplyReplenish() {
		Movement mov = newMovement(10);

		mov.apply();
		
		//assert
		verify(mov.getFood()).replenish(10);
	}

	@Test
	void testApplyRemove() {
		Movement mov = newMovement(-10);

		mov.apply();

		verify(mov.getFood()).remove(10);
		verify(mov.getFood(),never()).replenish(anyInt());
	}

	@Test
	void testApplyWith0() {
		Movement mov = newMovement(0);

		mov.apply();

		verify(mov.getFood()).replenish(0);
		verify(mov.getFood(),never()).remove(anyInt());
	}


	@Test
	void testApplyCancelRemove() {		
		Movement mov = newMovement(-10);

		mov.apply();
		mov.cancel();

		verify(mov.getFood()).remove(10);
		verify(mov.getFood()).replenish(10);
		assertEquals(MA_DATE, mov.getDate());
	}
		

	@Test
	void testApplyCancelReplenish() {		
		Movement mov = newMovement(10);

		mov.apply();
		mov.cancel();

		verify(mov.getFood()).replenish(10);
		verify(mov.getFood()).remove(10);
		assertEquals(MA_DATE, mov.getDate());
	}
	
	@Test
	void testApplyCancel0() {		
		Movement mov = newMovement(0);
		
		mov.apply();
		mov.cancel();
		
		verify(mov.getFood()).replenish(0);
		verify(mov.getFood(),never()).remove(anyInt());
		assertEquals(MA_DATE, mov.getDate());
	}

	

}
