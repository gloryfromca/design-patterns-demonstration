package j2ee_patterns;

import java.util.ArrayList;
import java.util.List;

interface BusinessService {
	public String getServiceType();

	public void doProcessing();
}

class LookUpService {
	List<BusinessService> businessServices = new ArrayList<BusinessService>();

	public void addService(BusinessService bs) {
		businessServices.add(bs);
	}

	public BusinessService getService(String serviceType) {
		for (BusinessService bs : businessServices) {
			if (bs.getServiceType() == serviceType)
				return bs;
		}
		return null;
	}
}

class EJBBusinessService implements BusinessService {

	@Override
	public String getServiceType() {
		return "EJB";
	}

	@Override
	public void doProcessing() {
		System.out.println("EJB processing...");
	}

}

class JMSBusinessService implements BusinessService {

	@Override
	public String getServiceType() {
		return "JMS";
	}

	@Override
	public void doProcessing() {
		System.out.println("JMS processing...");
	}

}

class BusinessDelegate {
	private LookUpService lookUpService = new LookUpService();
	private String serviceType;
	private BusinessService businessService;

	{
		lookUpService.addService(new JMSBusinessService());
		lookUpService.addService(new EJBBusinessService());

	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doProcessing() {
		businessService = lookUpService.getService(serviceType);
		businessService.doProcessing();
	}

}

public class BusinessDelegatePattern {

	public static void main(String[] args) {
		BusinessDelegate db = new BusinessDelegate();
		db.setServiceType("EJB");
		db.doProcessing();

	}

}
