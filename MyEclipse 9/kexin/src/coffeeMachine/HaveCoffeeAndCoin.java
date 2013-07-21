package coffeeMachine;

import javax.swing.ImageIcon;

public class HaveCoffeeAndCoin extends State {

	AutoCoffeeMahine machine;
	
	public HaveCoffeeAndCoin(AutoCoffeeMahine m)
	{
		machine = m;
	}
	
	public AutoCoffeeMahine getMachine()
	{
		return machine;
	}
	
	public void giveAnCupOfCoffee() {
		int count = machine.getCoffeeCount();
		
		if(count == 0)
		{
			machine.setState(machine.getHaveNotCoffee());
			machine.messShowing.setText("没有咖啡了");		//have no coffee now
			machine.messShowing.setIcon(new ImageIcon("no.jpg"));
			
		}
		else 
		{
			machine.messShowing.setIcon(new ImageIcon("coffee.jpg"));
			machine.setCoffeeCount(count -1);
			machine.setCoinNumber(machine.getCoinNumber() - 1);//取一份咖啡消费一枚硬币
			showMessage();
			
			if(count == 1)
				machine.setState(machine.getHaveNotCoffee());
			else{
				if(machine.getCoinNumber() == 0)//当所有硬币都消费或退回系统后再转为HaveCoffeeNoCoin状态
					machine.setState(machine.getHaveCoffeeNoCoin());
			}
		}
	}


	public void showMessage() {
		// TODO Auto-generated method stub
		int i = machine.getCoinNumber();
		if(i == 0){
			machine.messShowing.setText("您得到一杯咖啡");	
		}
		else{
			machine.messShowing.setText("请取出您的咖啡和剩余的" + i + "枚硬币");	
			machine.setCoinNumber(0);
		}
	}


	public String getStateName()
	{
		return "HaveCoffeeAndCoin";
	}
}
