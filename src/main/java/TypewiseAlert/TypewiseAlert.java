package TypewiseAlert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TypewiseAlert 
{
    public enum BreachType {
      NORMAL{
	        public String toString() {
	            return "NORMAL";
	            }
      },
      TOO_LOW{
	        public String toString() {
	            return "TOO_LOW";
	            }
      },
      TOO_HIGH{	        public String toString() {
          return "TOO_HIGH";
          }
      }
      
    };
    
    public enum CoolingType {
    	PASSIVE_COOLING {
    	        public String toString() {
    	            return "PASSIVE_COOLING";
    	            }
    	        },   	
  
        HI_ACTIVE_COOLING{
    	        	 public String toString() {
    	    	            return "HI_ACTIVE_COOLING";
    	        	}
    	        },
        MED_ACTIVE_COOLING{
    	        	 public String toString() {
    	    	            return "MED_ACTIVE_COOLING";
    	    	            }
    	        }
      };
    
    public enum AlertTarget{
        TO_CONTROLLER{
       	 public String toString() {
	            return "TO_CONTROLLER";
	            }
        }
        ,
        TO_EMAIL{
          	 public String toString() {
 	            return "TO_EMAIL";
 	            }
        }
      };
      
      
    public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
      if(value < lowerLimit) {
        return BreachType.TOO_LOW;
      }
      if(value > upperLimit) {
        return BreachType.TOO_HIGH;
      }
      return BreachType.NORMAL;
    }

    public static BreachType classifyTemperatureBreach(
      CoolingType coolingType, double temperatureInC){    
      CoolingSelector coolingSelector = new CoolingSelector();
      Class coolingClassSelector = coolingSelector.getClass();
      Method coolingClassMethodSelector;
	try {
		coolingClassMethodSelector = coolingClassSelector.getDeclaredMethod(coolingType.toString(), null);
	    coolingClassMethodSelector.invoke(coolingSelector);
	} catch (Exception e) {
		e.printStackTrace();
	}       
      int lowerLimit = coolingSelector.getLowerLimit();
      int upperLimit = coolingSelector.getUpperLimit();
           
      return inferBreach(temperatureInC, lowerLimit, upperLimit);
    }
    
    public static void checkAndAlert(
        AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC){
      BreachType breachType;
		try {
			  breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
		      AlertTargetSelector alertTargetSelector = new AlertTargetSelector();
		      Class alertTargetClassSelector = alertTargetSelector.getClass();
		      Method alertTargetClassMethodSelector = alertTargetClassSelector.getDeclaredMethod(alertTarget.toString(), TypewiseAlert.BreachType.class);		      
		      alertTargetClassMethodSelector.invoke(alertTargetSelector, breachType);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
    
    public static void sendToController(BreachType breachType) {
      int header = 0xfeed;
      System.out.printf("%i : %i\n", header, breachType);
    }
    
    public static void sendToEmail(BreachType breachType){
      String recepient = "a.b@c.com";
      BreachTypeSelector breachTypeSelector = new BreachTypeSelector();
      Class breachTypeClassSelector = breachTypeSelector.getClass();
      Method breachTypeClassMethodSelector;
	try {
		breachTypeClassMethodSelector = breachTypeClassSelector.getDeclaredMethod(breachType.toString(), String.class);
	    breachTypeClassMethodSelector.invoke(breachTypeSelector, recepient); 
	}catch (Exception e) {
		e.printStackTrace();
	}

    }
}
