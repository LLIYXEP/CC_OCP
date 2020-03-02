package serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B05_UID {
	
//	static class Foo implements Serializable {
//		private static final long serialVersionUID = 1L;
//		
//	}
	
	static class Foo implements Serializable {
	private static final long serialVersionUID = 2L;
		String att1;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		Object obj1 = new Foo();
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f1"));
//		oos.writeObject(obj1);
//		oos.close();
//		System.out.println("Serialisirt");
		
		ObjectInputStream ois = new  ObjectInputStream(new FileInputStream("f1"));
		Object obj2 = ois.readObject();
		ois.close();
		System.out.println("Deserialisirt");
		
	}
	
}
