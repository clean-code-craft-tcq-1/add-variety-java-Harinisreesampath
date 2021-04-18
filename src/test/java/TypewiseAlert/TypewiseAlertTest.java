package TypewiseAlert;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import TypewiseAlert.BatteryCharacter;
import alertSelector.*;
import coolingSelector.*;
import org.junit.Test;

public class TypewiseAlertTest 
{
	private FakeMail fakeMail;
	private FakeController fakeController;
    private FakeConsole fakeConsole;
    private HighActiveCooling highActiveCooling;
    private PassiveCoolingType passiveCoolingType;
    private MidActiveCooling midActiveCooling;
    private BatteryCharacter batteryCharacter; 
	List<INotifyObservers> iAlertTypes;
	
	@Before
	public void executedBeforeEach() {
		fakeMail = new FakeMail();
		fakeController = new FakeController();
		fakeConsole = new FakeConsole();
		highActiveCooling = new HighActiveCooling();
		passiveCoolingType = new PassiveCoolingType(); 
		midActiveCooling = new MidActiveCooling();
		batteryCharacter = new BatteryCharacter(highActiveCooling,"Brand");
		iAlertTypes = new ArrayList<INotifyObservers>();
		iAlertTypes.add(fakeMail);
		iAlertTypes.add(fakeController);
		iAlertTypes.add(fakeConsole);
    }	

    @Test
    public void infersBreachAsPerLimitsForTooLow()
    {
    	assertEquals(TypewiseAlert.inferBreach(12, 20, 30).getBreachType(),"TooLow");  
    }
    @Test
    public void infersBreachAsPerLimitsForTooHigh()
    {
    	assertEquals(TypewiseAlert.inferBreach(80, 20, 30).getBreachType(),"TooHigh");  
    }
    
    @Test
    public void infersBreachAsPerLimitsForNormal()
    {
    	assertEquals(TypewiseAlert.inferBreach(25, 20, 30).getBreachType(),"Normal");  
    }    
    
    @Test
    public void classifiesTemperatureBreachTypeForHighActiveCooling() {
       assertEquals(TypewiseAlert.classifyTemperatureBreach(highActiveCooling, 50).getBreachType(), "TooHigh");
    }
    
    @Test
    public void classifiesTemperatureBreachTypeForPassiveCoolingType() {
       assertEquals(TypewiseAlert.classifyTemperatureBreach(passiveCoolingType, 50).getBreachType(), "TooHigh");
    }
    
    @Test
    public void classifiesTemperatureBreachTypeForMidActiveCooling() {
       assertEquals(TypewiseAlert.classifyTemperatureBreach(midActiveCooling, 50).getBreachType(), "TooHigh");
    }
    
    @Test
    public void checkingAndAlertingHighBreachViaController() { 
        TypewiseAlert.checkAndAlert(fakeController,batteryCharacter, 60);
        assertEquals(fakeController.breachType, "TooHigh");
    }
    
    @Test
    public void checkingAndAlertingLowBreachViaController() { 
        TypewiseAlert.checkAndAlert(fakeController,batteryCharacter, -1);
        assertEquals(fakeController.breachType, "TooLow");
    }
    
    @Test
    public void checkingAndAlertingNormalValueViaController() { 
        TypewiseAlert.checkAndAlert(fakeController,batteryCharacter, 10);
        assertEquals(fakeController.breachType, "Normal");
    }
    
    @Test
     public void checkingAndAlertingHighBreachViaMail() { 
        TypewiseAlert.checkAndAlert(fakeMail,batteryCharacter, 60);
        assertEquals(fakeMail.breachType, "TooHigh");
    }    
    
    @Test
    public void checkingAndAlertingLowBreachViaMail() { 
       TypewiseAlert.checkAndAlert(fakeMail,batteryCharacter, -1);
       assertEquals(fakeMail.breachType, "TooLow");
   }
    
    @Test
    public void checkingAndAlertingHighBreachViaConsole() { 
        TypewiseAlert.checkAndAlert(fakeConsole,batteryCharacter, 60);
        assertEquals(fakeConsole.breachType, "TooHigh");
    }
    
    @Test
    public void checkingAndAlertingLowBreachViaConsole() { 
        TypewiseAlert.checkAndAlert(fakeConsole,batteryCharacter, -1);
        assertEquals(fakeConsole.breachType, "TooLow");
    }
    
    @Test
    public void checkingAndAlertingNormalValueViaConsole() { 
        TypewiseAlert.checkAndAlert(fakeConsole,batteryCharacter, 10);
        assertEquals(fakeConsole.breachType, "Normal");
    }
    
    @Test
    public void checkingAndAlertingAllSystems() {
        TypewiseAlert.checkAndAlertAllSystems(iAlertTypes,batteryCharacter,60);

    }

}
