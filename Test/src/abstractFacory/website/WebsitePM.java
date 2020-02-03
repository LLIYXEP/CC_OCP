package abstractFacory.website;

import abstractFacory.Manager;

public class WebsitePM implements Manager{

	@Override
	public void manageProject() {
		System.out.println("Website PM manages website project...");
	}

}
