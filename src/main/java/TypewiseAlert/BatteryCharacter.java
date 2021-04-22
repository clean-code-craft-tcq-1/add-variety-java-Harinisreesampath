package TypewiseAlert;

import coolingSelector.IIdentifyCoolingType;

public class BatteryCharacter {
    public IIdentifyCoolingType icoolingType;
    public String brand;
	public BatteryCharacter(IIdentifyCoolingType coolingType, String brand) {
		this.icoolingType = coolingType;
		this.brand = brand;
	}
}