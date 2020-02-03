package abstractFacory.banking;

import abstractFacory.Developer;
import abstractFacory.Manager;
import abstractFacory.ProjectTeamFactory;
import abstractFacory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {

	@Override
	public Developer getDeveloper() {
		return new JavaDeveloper();
	}

	@Override
	public Tester getTester() {
		return new QATester();
	}

	@Override
	public Manager getManager() {
		return new BankingPM();
	}

}
