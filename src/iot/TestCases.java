package iot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCases {

	Display disp = new Display();
	@Test
	void test() {
		//If the received gate signal gets corrupted and does not send a number value
		
		assertEquals(0,disp.checkGate("not a number"));
	}
	@Test
	void test2() {
		//If the received object distance gets corrupted and does not send a number value
		assertEquals(0,disp.checkObject("not a number"));
	}
	@Test
	void test3() {
		//If the received moving object distance gets corrupted and does not send a number value
		assertEquals(0,disp.checkAnimalNum("not, a number"));
	}
	@Test
	void test4() {
		//If the direction of the moving object is unknown, it should return a blank string for the direction.
		assertEquals(" ",disp.checkAnimal("21321,direction unknown"));
	}
	@Test
	void test5() {
		//If the wheel sensors provide an error, the IOT should be notified by a specific code.
		assertEquals(-1,disp.checkWheel("520,ERROR,525,520,522"));
	}
	
	@Test
	void test6() {
		//If the wheel sensors provide an error, the IOT should be notified by a specific code.
		assertEquals(1,disp.checkWheel("520,526,525,520,522"));
	}
	
	
}
