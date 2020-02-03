package abstractFacory.website;

import abstractFacory.Developer;
import abstractFacory.Manager;
import abstractFacory.ProjectTeamFactory;
import abstractFacory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {

	@Override
	public Developer getDeveloper() {
		return new PhpDeveloper();
	}

	@Override
	public Tester getTester() {
		return new ManualTester();
	}

	@Override
	public Manager getManager() {
		return new WebsitePM();
	}
	
}
