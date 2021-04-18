package alertSelector;

import breachTypeSelector.IIdentifyBreachType;

import java.util.ArrayList;
import java.util.List;

public class AlertHandler implements INotifyObservers {
	List<INotifyObservers> alerters = new ArrayList<INotifyObservers> ();
	
	public void addAllAlerters(INotifyObservers iAlertType) {
		alerters.add(iAlertType);
	}
	
	public void alertToAllSystems(IIdentifyBreachType breachType) {
		for(INotifyObservers alertType: alerters) {
			alertType.alert(breachType);
		}
	}
	
	@Override
	public void alert(IIdentifyBreachType breachType) {
		this.alertToAllSystems(breachType);
	}

}
