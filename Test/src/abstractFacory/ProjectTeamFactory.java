package abstractFacory;

public interface ProjectTeamFactory {

	Developer getDeveloper();
	Tester getTester();
	Manager getManager();
	
}
