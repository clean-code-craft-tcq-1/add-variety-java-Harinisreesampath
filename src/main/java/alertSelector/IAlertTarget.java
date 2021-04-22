package alertSelector;

import breachTypeSelector.IIdentifyBreachType;

public interface IAlertTarget {
	public void alert(IIdentifyBreachType breachType);
}
