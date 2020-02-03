package abstractFacory.banking;

import abstractFacory.Developer;

public class JavaDeveloper implements Developer{

	@Override
	public void writeCode() {
		System.out.println("JavaDeveloper wrights Java code...");
	}

}
