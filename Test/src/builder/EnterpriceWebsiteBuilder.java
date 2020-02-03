package builder;

public class EnterpriceWebsiteBuilder extends WebsiteBuilder {

	@Override
	void buildName() {
		website.setName("Enterprise web site");
	}

	@Override
	void buildCms() {
		website.setCms(Cms.ALIFRESCO);
	}

	@Override
	void buildPrice() {
		website.setPrice(10000);
	}

}
