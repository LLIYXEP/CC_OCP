package abstractFacory.banking;

import abstractFacory.Manager;

public class BankingPM implements Manager{

	@Override
	public void manageProject() {
		System.out.println("BankingMeneger manages banking project...");
	}

}
