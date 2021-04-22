package coolingSelector;

public class CoolingTypeFactory {
	IIdentifyCoolingType icooling;
	public CoolingTypeFactory (IIdentifyCoolingType icooling) {
		this.icooling = icooling;
	}
	
	public int getUpperLimit() {
		return icooling.fetchUpperLimit();
	}
	public int getLowerLimit() {
		return icooling.fetchLowerLimit();
	}
}
