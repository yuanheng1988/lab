package factory;

public class OperationFactory {
	
	public static Operation createOperate(String operate){
		Operation oper = null;
		if (operate.equals("+"))
			oper = new OperationAdd();
		else if (operate.equals("-"))
			oper = new OperationSub();
		else if (operate.equals("*"))
			oper = new OperationMul();
		else
			oper = new OperationDiv();
		
		return oper;
	}
	


}
