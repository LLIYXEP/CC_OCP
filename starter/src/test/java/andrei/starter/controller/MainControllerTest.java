package andrei.starter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainControllerTest {
	
	
	@Test
	public void test() {
		int x = 2;
		int y = 23;
		assertEquals(25, x + y);
	}
	

}
