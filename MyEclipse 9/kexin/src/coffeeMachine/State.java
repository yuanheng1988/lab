package coffeeMachine;

public abstract class State {
	public abstract void giveAnCupOfCoffee();
	public abstract void showMessage();
	public abstract String getStateName();
	public abstract AutoCoffeeMahine getMachine();

	final public void log(State nextState)
	{
		getMachine().writeLog("��\t"+getStateName()+"ת�Ƶ�\t"+nextState.getStateName()+"״̬");
	}
	
}
