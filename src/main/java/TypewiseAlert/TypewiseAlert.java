package TypewiseAlert;

import java.util.List;

import alertSelector.AlertHandler;
import alertSelector.INotifyObservers;
import breachTypeSelector.IIdentifyBreachType;
import breachTypeSelector.Normal;
import breachTypeSelector.TooHigh;
import breachTypeSelector.TooLow;
import coolingSelector.CoolingTypeFactory;
import coolingSelector.IIdentifyCoolingType;

public class TypewiseAlert 
{
	public static String breachMessage ;

	public static IIdentifyBreachType inferBreach(double value, double lowerLimit, double upperLimit) {
		if(value < lowerLimit) {
			breachMessage = "too low";
			return new TooLow();
      }
      if(value > upperLimit) {
    	  breachMessage = "too high";
    	  return new TooHigh();
      }
      return new Normal();
    }

    public static IIdentifyBreachType classifyTemperatureBreach(
      IIdentifyCoolingType icoolingType, double temperatureInC){     
	
      CoolingTypeFactory coolingTypeFactory = new CoolingTypeFactory(icoolingType);           
      return inferBreach(temperatureInC, coolingTypeFactory.getLowerLimit(), coolingTypeFactory.getUpperLimit());
    }
    
    public static void checkAndAlert(
      INotifyObservers ialertType, BatteryCharacter batteryChar, double temperatureInC){
      IIdentifyBreachType breachType = classifyTemperatureBreach(batteryChar.icoolingType, temperatureInC);
      ialertType.alert(breachType);
    }
    
    public static void checkAndAlertAllSystems(List<INotifyObservers> iAlertTypes,BatteryCharacter batteryChar, double temperatureInC) {
    	AlertHandler alertHandler = new AlertHandler();
    	for(INotifyObservers alerters: iAlertTypes) {
    		alertHandler.addAllAlerters(alerters);
    	}
    	INotifyObservers ialertType = alertHandler;
    	checkAndAlert(ialertType,batteryChar,temperatureInC);
    }

}
