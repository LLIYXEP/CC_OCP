package abstractFacory.website;

import abstractFacory.Developer;

public class PhpDeveloper implements Developer {

	@Override
	public void writeCode() {
		System.out.println("Php Developer wrights php code");
	}

}
