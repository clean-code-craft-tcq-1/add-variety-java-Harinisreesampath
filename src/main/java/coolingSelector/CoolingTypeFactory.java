package coolingSelector;

public class CoolingTypeFactory {
	ICoolingType icooling;
	public CoolingTypeFactory (ICoolingType icooling) {
		this.icooling = icooling;
	}
	
	public int getUpperLimit() {
		return icooling.fetchUpperLimit();
	}
	public int getLowerLimit() {
		return icooling.fetchLowerLimit();
	}
}
