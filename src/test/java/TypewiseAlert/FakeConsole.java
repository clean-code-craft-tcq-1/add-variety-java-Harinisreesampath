package TypewiseAlert;

import alertSelector.INotifyObservers;
import breachTypeSelector.IIdentifyBreachType;

public class FakeConsole implements INotifyObservers {
	public String breachType; 

	@Override
	public void alert(IIdentifyBreachType breachType) {
		this.breachType = breachType.getBreachType();
		
	}

}
