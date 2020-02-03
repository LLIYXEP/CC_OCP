package aufgaben.mylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

@SuppressWarnings("serial")
public class ArrayListPositive extends ArrayList<Integer> {

	@Override
	public void replaceAll(UnaryOperator<Integer> operator) {
		throw new UnsupportedOperationException();
	}
	
	private void checkElement(Integer e)  throws NullArgumentException, NotPostivieArgumentException {
		if (e == null) {
			throw new NullArgumentException();
		}
		if (e <= 0) {
			throw new NotPostivieArgumentException();
		}
	}
	
	@Override
	public boolean add(Integer element) throws NullArgumentException, NotPostivieArgumentException {
		checkElement(element);
		return super.add(element);
	}
	
	@Override
	public void add(int index, Integer element) throws NullArgumentException, NotPostivieArgumentException{
		checkElement(element);
		super.add(index, element);
	}
	
	@Override
	public boolean addAll(Collection<? extends Integer> c) throws NullArgumentException, NotPostivieArgumentException{
		c.forEach(element -> checkElement(element));
		return super.addAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends Integer> c) throws NullArgumentException, NotPostivieArgumentException{
		c.forEach(element -> checkElement(element));
		return super.addAll(index, c);
	}
	
	@Override
	public Integer set(int index, Integer element) throws NullArgumentException, NotPostivieArgumentException{
		checkElement(element);
		return super.set(index, element);
	}
}
