package abstractFacory;

import abstractFacory.banking.BankingTeamFactory;

public class SuperBankSystem {

	public static void main(String[] args) {
		
		ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
		Developer developer = projectTeamFactory.getDeveloper();
		Tester tester = projectTeamFactory.getTester();
		Manager manager = projectTeamFactory.getManager();
		
		System.out.println("Creating Bank system...");
		developer.writeCode();
		tester.testCode();
		manager.manageProject();
		
	}
}
