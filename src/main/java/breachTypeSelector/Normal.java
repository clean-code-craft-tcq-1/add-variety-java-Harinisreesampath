package breachTypeSelector;

public class Normal implements IIdentifyBreachType {
	String breachType;
	public Normal() {		
		this.breachType = "Normal";
	}
	@Override
	public String getBreachType() {
		return breachType;
	}

}
