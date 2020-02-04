package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

class StringTransform {
	
	private List<UnaryOperator> list = new ArrayList<UnaryOperator>();

	public StringTransform addTransformation(UnaryOperator<String> unop) {
		this.list.add(unop);
		return this;
	}

	public String process(String string) {
		for (UnaryOperator unaryOperator : list) {
			string = (String) unaryOperator.apply(string);
		}
		return string;
	};
	
}

public class FunctionStringTransform {

	public static void main(String[] args) {
		
		// Transformationen vordefinieren:
        StringTransform t1 = new StringTransform()
                .addTransformation( s -> s.toUpperCase() )
                .addTransformation( s -> s + "!" );
        
        // Transformationen durchführen:
        String s = t1.process("Hallo");
        System.out.println(s); // HALLO!
        
        s = t1.process("Java ist toll");
        System.out.println(s); // JAVA IST TOLL!
		
	}
	
}
