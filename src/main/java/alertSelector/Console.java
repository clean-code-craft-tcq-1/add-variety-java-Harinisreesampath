package alertSelector;

import breachTypeSelector.IIdentifyBreachType;

public class Console implements INotifyObservers {

	@Override
	public void alert(IIdentifyBreachType breachType) {
    	System.out.println("The breach type for the given temperature is "+ breachType.getBreachType());
		
	}


}
