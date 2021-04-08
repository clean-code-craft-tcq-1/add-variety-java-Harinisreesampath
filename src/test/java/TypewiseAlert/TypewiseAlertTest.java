package TypewiseAlert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import TypewiseAlert.BatteryCharacter;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(TypewiseAlert.inferBreach(12, 20, 30) ==  TypewiseAlert.BreachType.TOO_LOW);  
      assertTrue(TypewiseAlert.inferBreach(112, 20, 30) ==  TypewiseAlert.BreachType.TOO_HIGH);
      assertTrue(TypewiseAlert.inferBreach(26, 20, 30) ==  TypewiseAlert.BreachType.NORMAL);
    }
    
    @Test
    public void classifiesTemperatureBreachType() {
        assertTrue(TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.HI_ACTIVE_COOLING, 50) == TypewiseAlert.BreachType.TOO_HIGH);
        assertFalse(TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.PASSIVE_COOLING,50) == TypewiseAlert.BreachType.TOO_LOW);  
        assertFalse(TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.MED_ACTIVE_COOLING,0.05) == TypewiseAlert.BreachType.TOO_HIGH);
    }
    
    @Test
    public void checkingAndAlertingTheUser() {
        BatteryCharacter batteryCharacter  = new BatteryCharacter(TypewiseAlert.CoolingType.HI_ACTIVE_COOLING,"Brand"); 
        TypewiseAlert.checkAndAlert(TypewiseAlert.AlertTarget.TO_EMAIL,batteryCharacter, 60);
        TypewiseAlert.checkAndAlert(TypewiseAlert.AlertTarget.TO_CONTROLLER,batteryCharacter, 60);
        TypewiseAlert.checkAndAlert(TypewiseAlert.AlertTarget.TO_CONSOLE,batteryCharacter, 60);
    }
}
