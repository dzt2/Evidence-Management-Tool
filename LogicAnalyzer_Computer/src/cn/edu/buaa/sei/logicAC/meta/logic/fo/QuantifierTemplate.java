package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;

public interface QuantifierTemplate extends LogicFunctionTemplate{
	public void setInParameters(DiscourseDomain domain,LogicFormulation formulation) throws Exception;
}
