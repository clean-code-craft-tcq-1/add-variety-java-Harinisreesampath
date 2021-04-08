package TypewiseAlert;

import java.lang.reflect.InvocationTargetException;

import TypewiseAlert.TypewiseAlert.BreachType;

public class AlertTargetSelector {

	public void TO_CONTROLLER(BreachType breachType) {
		TypewiseAlert.sendToController(breachType);
	}
	
	public void TO_EMAIL(BreachType breachType){
		TypewiseAlert.sendToEmail(breachType);
	}
	
	public void TO_CONSOLE(BreachType breachType){
		TypewiseAlert.sentToConsole(breachType);
	}
}
