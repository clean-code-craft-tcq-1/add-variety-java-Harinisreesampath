package TypewiseAlert;

import static org.junit.Assert.*;
import TypewiseAlert.BatteryCharacter;
import alertSelector.*;
import breachTypeSelector.*;
import coolingSelector.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

 

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TypewiseAlertTest 
{
	
	
    @Test
    public void infersBreachAsPerLimits_TooLow()
    {
    	assertEquals(TypewiseAlert.inferBreach(12, 20, 30).getBreachType(),"TooLow");  
    }
    @Test
    public void infersBreachAsPerLimits_TooHigh()
    {
    	assertEquals(TypewiseAlert.inferBreach(80, 20, 30).getBreachType(),"TooHigh");  
    }
    
    @Test
    public void infersBreachAsPerLimits_Normal()
    {
    	assertEquals(TypewiseAlert.inferBreach(25, 20, 30).getBreachType(),"Normal");  
    }    
    
    @Test
    public void classifiesTemperatureBreachType_HighActiveCooling() {
       assertEquals(TypewiseAlert.classifyTemperatureBreach(new HighActiveCooling(), 50).getBreachType(), "TooHigh");
    }
    
    @Test
    public void classifiesTemperatureBreachType_PassiveCoolingType() {
       assertEquals(TypewiseAlert.classifyTemperatureBreach(new PassiveCoolingType(), 50).getBreachType(), "TooHigh");
    }
    
    @Test
    public void classifiesTemperatureBreachType_MidActiveCooling() {
       assertEquals(TypewiseAlert.classifyTemperatureBreach(new MidActiveCooling(), 50).getBreachType(), "TooHigh");
    }
    
    @Test
    public void checkingAndAlertingTheUser_Mail() { 
        BatteryCharacter batteryCharacter  = new BatteryCharacter(new HighActiveCooling(),"Brand");
       TypewiseAlert.checkAndAlert(new Mail(),batteryCharacter, 60);
    }
    
    @Test
    public void checkingAndAlertingTheUser_Controller() { 
        BatteryCharacter batteryCharacter  = new BatteryCharacter(new HighActiveCooling(),"Brand");
       TypewiseAlert.checkAndAlert(new Controller(),batteryCharacter, 60);
    }
    
    @Test
    public void checkingAndAlertingTheUser_Console() { 
        BatteryCharacter batteryCharacter  = new BatteryCharacter(new HighActiveCooling(),"Brand");
       TypewiseAlert.checkAndAlert(new Console(),batteryCharacter, 60);
    }
    
    
    @Test
    public void checkingAndAlertingTheUser() {   	
        BatteryCharacter batteryCharacter  = new BatteryCharacter(new HighActiveCooling(),"Brand");
        //TypewiseAlert.checkAndAlert(new Mail(),batteryCharacter, 60);
        TypewiseAlert typewiseAlert = spy(new TypewiseAlert());
        typewiseAlert.checkAndAlert(new Console(), batteryCharacter, 60);
        verify(typewiseAlert).checkAndAlert(new Console(), batteryCharacter, 60);

    }


}
