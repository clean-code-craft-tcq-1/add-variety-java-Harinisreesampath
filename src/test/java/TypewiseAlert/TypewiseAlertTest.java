package TypewiseAlert;

import static org.junit.Assert.assertEquals;
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
    }
    
    @Test
    public void classifiesTemperatureBreachType() {
        assertTrue(TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.HI_ACTIVE_COOLING, 50) == TypewiseAlert.BreachType.TOO_HIGH);
    }
    
    @Test
    public void checkingAndAlertingTheUser() {
        BatteryCharacter batteryCharacter  = new BatteryCharacter(TypewiseAlert.CoolingType.HI_ACTIVE_COOLING,"Brand"); 
        TypewiseAlert.checkAndAlert(TypewiseAlert.AlertTarget.TO_EMAIL,batteryCharacter, 60);
    }
}
