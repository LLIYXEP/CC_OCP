package scurtu.com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
	void beforeAllInit() {
		System.out.println("This needs to be run bedore all");
	}
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleanning up...");
	}

	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		
		assertEquals(expected, actual, "The add method shoud add two numbers");
	}
	
	@Test
	void testDivide() {
		assumeTrue(false); // If false don't execute the code
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by 0 should throw ");
		
	}
	
	@Test
	void testComputerCircleRadius() {
		assertEquals(314.1592653589793, mathUtils.computerCircleArea(10), "Shoud return right Circle Area");
	}
	
	@Test
	@DisplayName("TDD shoud not run")
	@Disabled
	void testDisabled() {
		fail("This test shoud be disabled");
	}

}
