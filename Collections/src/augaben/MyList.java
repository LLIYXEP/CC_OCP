package augaben;

public class MyList {

	public String[] strings = new String[10];
	
	public void add(String element) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[strings.length - 1] != null) {
				throw new ArrayIndexOutOfBoundsException("Array is full");
			}
			if (strings[i] != null) {
				continue;
			}
			else if (strings[i] == null) {
				strings[i] = element;
				break;
			} 
			
		}
	}
	
	public int size() {
		int result = 0;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] != null) {
				result += 1;
			}
		}
		return result;
	}
	
	public String get(int index) {
		String result = "";
		for (int i = 0; i < strings.length; i++) {
			if (i == index - 1) {
				result = strings[i];
			} else if ( index < 1 ) {
				throw new ArrayIndexOutOfBoundsException("Aiaiai < 0");
			} else if ( strings[index-1] == null ) {
				throw new NullPointerException("Tut pusto poka");
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		MyList ml = new MyList();
		ml.add("First");
		ml.add("2");
		ml.add("3");
		ml.add("4");
		ml.add("5");
		ml.add("6");
		ml.add("7");
		ml.add("8");
		ml.add("9");
		
		System.out.println(ml.size());
		
		System.out.println(ml.get(10));
		
	}
	
}
