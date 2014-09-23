package cn.edu.buaa.sei.logicAC.meta.logic;

public interface Equivalence extends LogicOperator{
	public LogicFormulation getF1();
	public LogicFormulation getF2();
	public void setF1(LogicFormulation f1);
	public void setF2(LogicFormulation f2);
}
