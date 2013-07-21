package coffeeMachine;

public abstract class State {
	public abstract void giveAnCupOfCoffee();
	public abstract void showMessage();
	public abstract String getStateName();
	public abstract AutoCoffeeMahine getMachine();

	final public void log(State nextState)
	{
		getMachine().writeLog("´Ó\t"+getStateName()+"×ªÒÆµ½\t"+nextState.getStateName()+"×´Ì¬");
	}
	
}
