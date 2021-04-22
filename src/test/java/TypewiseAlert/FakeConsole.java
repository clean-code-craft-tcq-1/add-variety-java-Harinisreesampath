package TypewiseAlert;

import alertSelector.IAlertTarget;
import breachTypeSelector.IIdentifyBreachType;

public class FakeConsole implements IAlertTarget {
	public String breachType; 

	@Override
	public void alert(IIdentifyBreachType breachType) {
		this.breachType = breachType.getBreachType();
		
	}

}
