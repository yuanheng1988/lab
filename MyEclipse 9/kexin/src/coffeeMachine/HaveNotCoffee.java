package coffeeMachine;

import javax.swing.ImageIcon;

public class HaveNotCoffee extends State {

	AutoCoffeeMahine machine;
	
	public HaveNotCoffee(AutoCoffeeMahine m)
	{
		machine = m;
	}
	
	@Override
	public void giveAnCupOfCoffee() {
		machine.messShowing.setIcon(new ImageIcon("no.jpg"));
		machine.putInCoin.setEnabled(false);
		machine.getCoffee.setEnabled(false);
		machine.returnCoin.setEnabled(false);
		showMessage();
	}

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		machine.messShowing.setText("Ŀǰ������û�п���");
	}

	@Override
	public AutoCoffeeMahine getMachine() {
		// TODO Auto-generated method stub
		return machine;
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "HaveNotCoffee";
	}

}
