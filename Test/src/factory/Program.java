package factory;

class Javadev implements Developer{

	@Override
	public void writeCode() {
		System.out.println("Java dev wrights code");
	}
	
}

class Cppdev implements Developer{

	@Override
	public void writeCode() {
		System.out.println("Cpp dev wrights code");
		
	}
	
}

class PHPdev implements Developer{

	@Override
	public void writeCode() {
		System.out.println("PHP dev wrights code");
	}
	
}

public class Program {

	public static void main(String[] args) {
		
		DeveloperFactory developerFactory = createDeveloperBySpeciality("php");
		Developer developer = developerFactory.createDeveloper();
		developer.writeCode();
		
	}
	
	static DeveloperFactory createDeveloperBySpeciality(String speciality) {
		if (speciality.equalsIgnoreCase("java")) {
			return new JavaDeveloperFactory();
		} else if (speciality.equalsIgnoreCase("cpp")) {
			return new CppDeveloperFactory();
		} else if (speciality.equalsIgnoreCase("php")) {
			return new PhpDeveloperFactory();
		} else {
			throw new RuntimeException(speciality + " is unknown speciality.");
		}
	}
}
