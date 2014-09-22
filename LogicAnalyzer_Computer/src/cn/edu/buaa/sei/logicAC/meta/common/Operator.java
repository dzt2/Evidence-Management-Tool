package cn.edu.buaa.sei.logicAC.meta.common;

public interface Operator{
	public static int ONE_DIMENSION = 1;
	public static int TWO_DIMENSION = 2;
	public static int THREE_DEMENSION = 3;
	public static int VARIABLE_DEMENSION = -1;
	
	public int getDimension();
	
	public Computable[] getParameters();
	public Computable getParameter(int i);
	public int getCurrentSize();
}
