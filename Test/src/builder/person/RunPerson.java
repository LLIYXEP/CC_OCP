package builder.person;

public class RunPerson {

	public static void main(String[] args) {
		
		Person p1 = new Person.Builder()
				.withName("Andrei")
				.withLastName("Scurtu")
				.withAge(31)
				.withStatus(true)
				.build();
		
		Person p2 = new Person.Builder()
				.withName("Andrei")
				.build();
		
		System.out.println(p1);
		System.out.println(p2);
		
	}
	
}
