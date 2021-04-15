package alertSelector;

import breachTypeSelector.IBreachType;

public class Mail implements IAlertType {

	@Override
	public void alert(IBreachType breachType) {
		 String recepient = "a.b@c.com";
		 breachType.breachMessage(recepient);
	}

}
