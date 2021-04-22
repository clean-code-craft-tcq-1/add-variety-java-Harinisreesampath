package breachTypeSelector;

public class TooLow implements IIdentifyBreachType {
	String breachType;
	public TooLow() {		
		this.breachType = "TooLow";
	}
	@Override
	public String getBreachType() {
		return breachType;
	}

}
