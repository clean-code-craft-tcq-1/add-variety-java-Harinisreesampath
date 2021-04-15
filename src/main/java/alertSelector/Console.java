package alertSelector;

import breachTypeSelector.IBreachType;

public class Console implements IAlertType {

	@Override
	public void alert(IBreachType breachType) {
    	System.out.println("The breach type for the given temperature is "+ breachType.getBreachType());
		
	}


}
