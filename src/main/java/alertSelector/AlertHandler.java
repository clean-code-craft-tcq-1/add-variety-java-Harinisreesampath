package alertSelector;

import breachTypeSelector.IIdentifyBreachType;

import java.util.ArrayList;
import java.util.List;

public class AlertHandler implements IAlertTarget {
	List<IAlertTarget> alerters = new ArrayList<IAlertTarget> ();
	
	public void addAllTargetSystems(IAlertTarget iAlertType) {
		alerters.add(iAlertType);
	}
	
	public void alertToAllSystems(IIdentifyBreachType breachType) {
		for(IAlertTarget alertType: alerters) {
			alertType.alert(breachType);
		}
	}
	
	@Override
	public void alert(IIdentifyBreachType breachType) {
		this.alertToAllSystems(breachType);
	}

}
