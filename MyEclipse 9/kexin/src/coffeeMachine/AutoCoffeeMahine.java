package coffeeMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AutoCoffeeMahine extends JFrame{
	
	final private static String logFile = ".\\log.txt";
	
	private State haveCoffeeNoCoin, haveCoffeeAndCoin, haveNotCoffee;
	private State state;
	private int isMaintenance;
	JButton putInCoin, getCoffee, returnCoin, maintenance;
	JLabel messShowing;
	private int coffeeCount; 
	private int coinNumber;		//用户已经投入、但未用于购买咖啡的硬币数目
	
	
	AutoCoffeeMahine(int coffeeCount)
	{
		coinNumber = 0;
		this.coffeeCount = coffeeCount;
		haveCoffeeNoCoin = new HaveCoffeeNoCoin(this);
		haveCoffeeAndCoin = new HaveCoffeeAndCoin(this);
		haveNotCoffee = new HaveNotCoffee(this);
		state = haveCoffeeNoCoin;
		
		putInCoin = new JButton("投币");
		getCoffee = new JButton("取咖啡");
		returnCoin = new JButton("退币");		
		maintenance = new JButton();
		maintenance.setIcon(new ImageIcon("icon.jpg"));
		maintenance.setMaximumSize(new Dimension(10, 10));
		
		initPubInCoinButton();
		initgetCoffeeButton();
		initReturnCoinButton();
		initMaintenanceButton();
		
		messShowing = new JLabel();
		messShowing.setIcon(new ImageIcon("machine.jpg"));
		messShowing.setFont(new Font("",Font.BOLD,20));
		JPanel pSouth = new JPanel();
		pSouth.add(putInCoin);
		pSouth.add(getCoffee);
		pSouth.add(returnCoin);
		pSouth.add(maintenance);
		add(messShowing, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

		private void initReturnCoinButton() 
		{
			returnCoin.addActionListener(new ActionListener(){
		
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(isState(haveCoffeeAndCoin)){
						
						setState(haveCoffeeNoCoin);
						messShowing.setText("请您取回退币" + getCoinNumber() + "枚"); 
						setCoinNumber(0);						
						messShowing.setIcon(new ImageIcon("coin.jpg"));
					}
					else if(isState(haveCoffeeNoCoin)){
						messShowing.setText("您还没有投币");
						messShowing.setIcon(new ImageIcon("machine.jpg"));
					}
					else if(isState(haveNotCoffee)){
						messShowing.setText("您还没有投币");
						messShowing.setIcon(new ImageIcon("machine.jpg"));
					}
				}
			});			
		}

	private void initPubInCoinButton()
	{
		putInCoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent exp)
			{
				if(isState(haveCoffeeNoCoin))
				{
					setState(haveCoffeeAndCoin);
					setCoinNumber(coinNumber + 1);
					messShowing.setText("您投币" + coinNumber + "枚，请取咖啡");
					messShowing.setIcon(new ImageIcon("machine.jpg"));
					
				}else if(isState(haveCoffeeAndCoin))
				{
					setCoinNumber(coinNumber + 1);
					messShowing.setText("您投币" + coinNumber + "枚，请取咖啡");
					messShowing.setIcon(new ImageIcon("machine.jpg"));
					
				}else if(isState(haveNotCoffee))
				{
					messShowing.setText("没有咖啡，无法投币");
					messShowing.setIcon(new ImageIcon("no.jpg"));
				}
			}
		});
	}
	
	private void initMaintenanceButton()
	{
		maintenance.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent exp)
			{
				if(isMaintenance == 0){
				isMaintenance = 1;
				String inputPassword = JOptionPane.showInputDialog( "请输入管理员密码:" );
				
				if(inputPassword.equals("1234"))
				{
					messShowing.setText("咖啡机正在维护中。。。");
					messShowing.setIcon(new ImageIcon("maintenance.jpg"));
										
					putInCoin.setEnabled(false);
					getCoffee.setEnabled(false);
					returnCoin.setEnabled(false);
					
					if(coinNumber != 0){
						messShowing.setText("请取回您已投入的" + coinNumber + "枚硬币。咖啡机正在维护中。。。");
						setCoinNumber(0);
					}
				}
				else{
					 JOptionPane.showMessageDialog( null,
					     "你在输入的密码不正确","消息", JOptionPane.PLAIN_MESSAGE );
				}
				}
				else{
					String inputPassword = JOptionPane.showInputDialog( "请输入管理员密码:" );
					if(inputPassword.equals("1234"))
					{
					putInCoin.setEnabled(true);
					getCoffee.setEnabled(true);
					returnCoin.setEnabled(true);
					
					messShowing.setText("咖啡机运行正常");
					messShowing.setIcon(new ImageIcon("machine.jpg"));
					}
				}
			}
		});
	}
	
	private void initgetCoffeeButton()
	{
		getCoffee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent exp)
			{
				giveAnCupOfCoffee();
			}
		});
	}
	
	public void giveAnCupOfCoffee()
	{
		state.giveAnCupOfCoffee();
	}
	
	public void showMessage()
	{
		state.showMessage();
	}

	public int getCoffeeCount() {
		// TODO Auto-generated method stub
		return this.coffeeCount;
	}
	
	public State getHaveCoffeeNoCoin() {
		return haveCoffeeNoCoin;
	}

	public State getHaveCoffeeAndCoin() {
		return haveCoffeeAndCoin;
	}

	public State getHaveNotCoffee() {
		return haveNotCoffee;
	}


	public void setState(State state) {
		this.state.log(state);
		this.state = state;
	}

	public void setCoffeeCount(int i) {
		// TODO Auto-generated method stub
		this.coffeeCount = i;
	}
	
	public int getCoinNumber() {
		return coinNumber;
	}

	public void setCoinNumber(int coinNumber) {
		this.coinNumber = coinNumber;
	}
	
	public boolean isState(State state)
	{
		return this.state.equals(state);
	}
	
	//write the log msg to the log file
	public void writeLog(String logMsg)
	{
		File log = new File(logFile);
		FileWriter output;
		try {
			output = new  FileWriter(log, true);			
			Calendar cal = Calendar.getInstance();
	    	cal.getTime();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	logMsg =  sdf.format(cal.getTime()) + "  "+logMsg +"\n";
			output.append(logMsg);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
