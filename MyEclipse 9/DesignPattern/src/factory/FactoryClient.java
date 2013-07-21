package factory;

public class FactoryClient {
	
	public static void main(String[] args){
		Operation oper = OperationFactory.createOperate("/");
		oper.setNumberA(3.323);
		oper.setNumberB(3232);
		double result = oper.getResult();
		System.out.println(result);
	}
}
