package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

class StringTransform2 {
	
	private List<UnaryOperator> list = new ArrayList<UnaryOperator>();

	StringTransform2 addTransformation(UnaryOperator<String> unop) {
		list.add(unop);
		return this;
	}

	String process(String string) {
		for (UnaryOperator unaryOperator : list) {
			string = (String) unaryOperator.apply(string);
		}
		return string;
	};
	
}

public class FunctionStringTransform2 {

	public static void main(String[] args) {
		
		// Transformationen vordefinieren:
        StringTransform2 t1 = new StringTransform2()
                .addTransformation( s -> s.toUpperCase() )
                .addTransformation( s -> s + "!" );
        
        // Transformationen durchführen:
        String s = t1.process("Hallo");
        System.out.println(s); // HALLO!
        
        s = t1.process("Java ist toll");
        System.out.println(s); // JAVA IST TOLL!
		
	}
	
}
