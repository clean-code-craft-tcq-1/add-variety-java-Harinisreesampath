package TypewiseAlert;

public class CoolingSelector {

int lowerLimit =0 ,upperLimit = 0;

public int getLowerLimit() {
	return lowerLimit;
}

public int getUpperLimit() {
	return upperLimit;
}

public void PASSIVE_COOLING() {
	this.lowerLimit = 0;
	this.upperLimit = 35;
}

public void HI_ACTIVE_COOLING() {
	this.lowerLimit = 0;
	this.upperLimit = 45;
}

public void MED_ACTIVE_COOLING() {
	this.lowerLimit = 0;
	this.upperLimit = 40;
}
}
