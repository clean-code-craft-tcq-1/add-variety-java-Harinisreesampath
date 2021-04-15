package TypewiseAlert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import alertSelector.IAlertType;
import breachTypeSelector.IBreachType;
import breachTypeSelector.Normal;
import breachTypeSelector.TooHigh;
import breachTypeSelector.TooLow;
import coolingSelector.CoolingTypeFactory;
import coolingSelector.ICoolingType;

public class TypewiseAlert 
{
    public static IBreachType inferBreach(double value, double lowerLimit, double upperLimit) {
      if(value < lowerLimit) {
        return new TooLow();
      }
      if(value > upperLimit) {
        return new TooHigh();
      }
      return new Normal();
    }

    public static IBreachType classifyTemperatureBreach(
      ICoolingType icoolingType, double temperatureInC){     
	
      CoolingTypeFactory coolingTypeFactory = new CoolingTypeFactory(icoolingType);           
      return inferBreach(temperatureInC, coolingTypeFactory.getLowerLimit(), coolingTypeFactory.getUpperLimit());
    }
    
    public static void checkAndAlert(
      IAlertType ialertType, BatteryCharacter batteryChar, double temperatureInC){
      IBreachType breachType = classifyTemperatureBreach(batteryChar.icoolingType, temperatureInC);
      ialertType.alert(breachType);
    }

}
