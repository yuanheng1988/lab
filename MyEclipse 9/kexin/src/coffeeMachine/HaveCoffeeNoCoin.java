package coffeeMachine;
import javax.swing.*;

public class HaveCoffeeNoCoin extends State {

	AutoCoffeeMahine machine;
	
	public HaveCoffeeNoCoin(AutoCoffeeMahine m)
	{
		machine = m;
	}
	
	@Override
	public void giveAnCupOfCoffee() {
		machine.messShowing.setIcon(new ImageIcon("machine.jpg"));
		showMessage();
	}

	@Override
	public void showMessage() {
		machine.messShowing.setText("请投入一枚一元硬币");
	}

	@Override
	public AutoCoffeeMahine getMachine() {
		return machine;
	}

	@Override
	public String getStateName() {
		return "HaveCoffeeNoCoin";
	}

}
