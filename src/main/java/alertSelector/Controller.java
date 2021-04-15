package alertSelector;

import breachTypeSelector.IBreachType;

public class Controller implements IAlertType {

	@Override
	public void alert(IBreachType breachType) {
	      int header = 0xfeed;
	      System.out.printf("%d : \n", header, breachType);
	}


}
