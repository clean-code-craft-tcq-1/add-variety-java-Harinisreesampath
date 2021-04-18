package coolingSelector;

public class HighActiveCooling implements IIdentifyCoolingType{

	@Override
	public int fetchUpperLimit() {
		return 45;
	}

	@Override
	public int fetchLowerLimit() {
		return 0;
	}

}
