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
			machine.messShowing.setText("û�п�����");		//have no coffee now
			machine.messShowing.setIcon(new ImageIcon("no.jpg"));
			
		}
		else 
		{
			machine.messShowing.setIcon(new ImageIcon("coffee.jpg"));
			machine.setCoffeeCount(count -1);
			machine.setCoinNumber(machine.getCoinNumber() - 1);//ȡһ�ݿ�������һöӲ��
			showMessage();
			
			if(count == 1)
				machine.setState(machine.getHaveNotCoffee());
			else{
				if(machine.getCoinNumber() == 0)//������Ӳ�Ҷ����ѻ��˻�ϵͳ����תΪHaveCoffeeNoCoin״̬
					machine.setState(machine.getHaveCoffeeNoCoin());
			}
		}
	}


	public void showMessage() {
		// TODO Auto-generated method stub
		int i = machine.getCoinNumber();
		if(i == 0){
			machine.messShowing.setText("���õ�һ������");	
		}
		else{
			machine.messShowing.setText("��ȡ�����Ŀ��Ⱥ�ʣ���" + i + "öӲ��");	
			machine.setCoinNumber(0);
		}
	}


	public String getStateName()
	{
		return "HaveCoffeeAndCoin";
	}
}
