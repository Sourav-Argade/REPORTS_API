package in.storm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.storm.entity.EligibilityDetails;
import in.storm.entity.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner{
	
	@Autowired
	private EligibilityDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		EligibilityDetails entity1 = new EligibilityDetails();
		entity1.setEligId(1);
		entity1.setName("Rushi");
		entity1.setEmail("rushi@gmail.com");
		entity1.setMobile(937323019);
		entity1.setGender('M');
		entity1.setSsn(732328382);
		entity1.setPlanName("LIC_Policy");
		entity1.setPlanStatus("Approved");
		repo.save(entity1);
		
		EligibilityDetails entity2 = new EligibilityDetails();
		entity2.setEligId(2);
		entity2.setName("Sayli");
		entity2.setEmail("sayli@gmail.com");
		entity2.setMobile(782787426);
		entity2.setGender('F');
		entity2.setSsn(732898262);
		entity2.setPlanName("CCAP");
		entity2.setPlanStatus("Denied");
		repo.save(entity2);
		
		EligibilityDetails entity3 = new EligibilityDetails();
		entity3.setEligId(3);
		entity3.setName("Adesh");
		entity3.setEmail("adesh@gmail.com");
		entity3.setMobile(989138363);
		entity3.setGender('M');
		entity3.setSsn(732645235);
		entity3.setPlanName("Medicaid");
		entity3.setPlanStatus("Closed");
		repo.save(entity3);
		
	}

}
