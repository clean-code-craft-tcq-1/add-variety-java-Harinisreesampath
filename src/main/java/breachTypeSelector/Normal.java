package breachTypeSelector;

public class Normal implements IBreachType {
	String breachType;
	public Normal() {		
		this.breachType = "Normal";
	}
	@Override
	public String getBreachType() {
		return breachType;
	}
	@Override
	public void breachMessage(String recepient) {
        System.out.printf("To: %s\n", recepient);
        System.out.println("Hi, the temperature is too normal\n");		
	}
	
}
