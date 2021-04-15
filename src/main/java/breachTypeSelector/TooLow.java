package breachTypeSelector;

public class TooLow implements IBreachType {
	String breachType;
	public TooLow() {		
		this.breachType = "TooLow";
	}
	@Override
	public String getBreachType() {
		return breachType;
	}
	@Override
	public void breachMessage(String recepient) {
        System.out.printf("To: %s\n", recepient);
        System.out.println("Hi, the temperature is too low\n");		
	}
}
