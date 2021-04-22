package coolingSelector;

public class MidActiveCooling implements IIdentifyCoolingType{

	@Override
	public int fetchUpperLimit() {
		return 40;
	}

	@Override
	public int fetchLowerLimit() {
		return 0;
	}

}
