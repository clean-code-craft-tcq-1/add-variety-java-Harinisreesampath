package breachTypeSelector;

public class TooHigh implements IBreachType {
String breachType;
	public TooHigh() {		
		this.breachType = "TooHigh";
	}
	@Override
	public String getBreachType() {
		return breachType;
	}
	@Override
	public void breachMessage(String recepient) {
        System.out.printf("To: %s\n", recepient);
        System.out.println("Hi, the temperature is too high\n");
	}

}
