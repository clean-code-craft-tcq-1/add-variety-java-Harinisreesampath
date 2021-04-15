package alertSelector;

import breachTypeSelector.IBreachType;

public interface IAlertType {
	public void alert(IBreachType breachType);
}
