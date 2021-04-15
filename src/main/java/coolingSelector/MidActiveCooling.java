package coolingSelector;

public class MidActiveCooling implements ICoolingType{

	@Override
	public int fetchUpperLimit() {
		return 40;
	}

	@Override
	public int fetchLowerLimit() {
		return 0;
	}

}
