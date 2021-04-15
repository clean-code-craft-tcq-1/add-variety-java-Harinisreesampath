package TypewiseAlert;

import coolingSelector.ICoolingType;

public class BatteryCharacter {
    public ICoolingType icoolingType;
    public String brand;
	public BatteryCharacter(ICoolingType coolingType, String brand) {
		this.icoolingType = coolingType;
		this.brand = brand;
	}
}