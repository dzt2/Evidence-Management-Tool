package cn.edu.buaa.sei.logicAC.meta.logic;

public interface Implication extends LogicOperator{
	public LogicFormulation getPrecondition();
	public LogicFormulation getConclusion();
	public void setPrecondition(LogicFormulation precondition);
	public void setConclusion(LogicFormulation conclusion);
}
