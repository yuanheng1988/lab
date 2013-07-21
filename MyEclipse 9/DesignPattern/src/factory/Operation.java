package factory;

public abstract class Operation {
	
	private double numberA = 0; 
	public double getNumberA() {
		return numberA;
	}

	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}

	public double getNumberB() {
		return numberB;
	}

	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}

	private double numberB = 0;
	
	public abstract double getResult();
}

class OperationAdd extends Operation{
	@Override
	public double getResult(){
		double result = 0;
		result = getNumberA() + getNumberB();
		return result;
	}
}

class OperationSub extends Operation{
	public double getResult(){
		double result = 0;
		result = getNumberA() - getNumberB();
		return result;
	}
}

class OperationMul extends Operation{
	public double getResult(){
		double result = 0;
		result = getNumberA() * getNumberB();
		return result;
	}
}

class OperationDiv extends Operation{
	public double getResult(){
		double result = 0;
		if (getNumberB() == 0)
			try {
				throw new Exception("除数不能为0");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		result = getNumberA() / getNumberB();
		return result;
	}
}

