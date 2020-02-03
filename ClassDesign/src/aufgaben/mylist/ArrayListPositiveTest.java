package aufgaben.mylist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class ArrayListPositiveTest {

	//NullArgumentException
	@Test
	void addingNullFails() {
		
		ArrayListPositive instance = new ArrayListPositive();
		
		assertThrows(NullArgumentException.class, () ->instance.add(null));
		
		assertThrows(NullArgumentException.class, () ->instance.add(0, null));
		
		Collection<Integer> collection = Arrays.asList(null, null);
		
		assertThrows(NullArgumentException.class, () ->instance.addAll(collection));
		
		assertThrows(NullArgumentException.class, () ->instance.addAll(0, collection));
		
		instance.add(12);
		assertThrows(NullArgumentException.class, () ->instance.set(0, null));
		
	}
	
	@Test
	void addingZeroOrNegativeFails() {
		
		ArrayListPositive instance = new ArrayListPositive();
		
		assertThrows(NotPostivieArgumentException.class, () ->instance.add(0));
		assertThrows(NotPostivieArgumentException.class, () ->instance.add(-1));
		
		assertThrows(NotPostivieArgumentException.class, () ->instance.add(0, 0));
		assertThrows(NotPostivieArgumentException.class, () ->instance.add(0, -1));
		
		Collection<Integer> collection = Arrays.asList(12, 0);
		
		assertThrows(NotPostivieArgumentException.class, () ->instance.addAll(collection));
		assertThrows(NotPostivieArgumentException.class, () ->instance.addAll(Arrays.asList(12, -1)));
		
		assertThrows(NotPostivieArgumentException.class, () ->instance.addAll(0, collection));
		assertThrows(NotPostivieArgumentException.class, () ->instance.addAll(0, Arrays.asList(12, -1)));
		
		instance.add(12);
		assertThrows(NotPostivieArgumentException.class, () ->instance.set(0, 0));
		assertThrows(NotPostivieArgumentException.class, () ->instance.set(0, -1));
		
	}
	
	@Test
	void replaceAllfailsAlwaysAsNotImplemented() {
		ArrayListPositive instance = new ArrayListPositive();
		
		assertThrows(UnsupportedOperationException.class, () -> instance.replaceAll(null)); 
	}

}
