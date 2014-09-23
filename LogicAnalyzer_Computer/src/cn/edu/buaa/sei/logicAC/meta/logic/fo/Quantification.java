package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.Operator;
import cn.edu.buaa.sei.logicAC.meta.logic.LogicFormulation;

public interface Quantification extends LogicFormulation,Operator{
	public static int UNBOUNDE = -1;
	
	public DiscourseDomain getDomain();
	public void setDomain(DiscourseDomain domain);
	public LogicFormulation getFormulation();
	public void setFormulation(LogicFormulation formulation);
}
