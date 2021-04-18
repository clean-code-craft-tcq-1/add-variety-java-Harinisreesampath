package breachTypeSelector;

public class TooHigh implements IIdentifyBreachType {
String breachType;
	public TooHigh() {		
		this.breachType = "TooHigh";
	}
	@Override
	public String getBreachType() {
		return breachType;
	}

}
