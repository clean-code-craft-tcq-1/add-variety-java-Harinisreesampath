package alertSelector;

import TypewiseAlert.TypewiseAlert;
import breachTypeSelector.IIdentifyBreachType;

public class Mail implements IAlertTarget {
	@Override
	public void alert(IIdentifyBreachType breachType) {
		if(TypewiseAlert.breachMessage != null) {
			String recepient = "a.b@c.com";		 
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is "+ TypewiseAlert.breachMessage);
		 }
	}

}
