package alertSelector;

import breachTypeSelector.IIdentifyBreachType;

public class Controller implements IAlertTarget {

	@Override
	public void alert(IIdentifyBreachType breachType) {
	      int header = 0xfeed;
	      System.out.printf("%d : \n", header, breachType);
	}


}
