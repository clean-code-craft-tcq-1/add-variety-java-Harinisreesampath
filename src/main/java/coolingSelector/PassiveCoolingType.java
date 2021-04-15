package coolingSelector;

public class PassiveCoolingType implements ICoolingType{

	@Override
	public int fetchUpperLimit() {
		return 35;
	}

	@Override
	public int fetchLowerLimit() {
		return 0;
	}

}
