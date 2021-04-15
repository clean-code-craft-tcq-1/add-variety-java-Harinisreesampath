package coolingSelector;

public class HighActiveCooling implements ICoolingType{

	@Override
	public int fetchUpperLimit() {
		return 45;
	}

	@Override
	public int fetchLowerLimit() {
		return 0;
	}

}
