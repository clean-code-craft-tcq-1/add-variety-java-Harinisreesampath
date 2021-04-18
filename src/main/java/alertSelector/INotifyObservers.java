package alertSelector;

import breachTypeSelector.IIdentifyBreachType;

public interface INotifyObservers {
	public void alert(IIdentifyBreachType breachType);
}
