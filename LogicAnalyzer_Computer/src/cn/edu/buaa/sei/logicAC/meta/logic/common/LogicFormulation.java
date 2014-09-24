package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;

/**
 * LogicFormulation is the computable used in logic computation.<br>
 * 1) Computable.result: Object<br>
 * 2) LogicFormulation.result: Boolean
 * */
public interface LogicFormulation extends Computable{
	/**
	 * Return the boolean result of the logic formulation.<br> 
	 * Before execution, return null.
	 * */
	public Boolean getResult();
	/**
	 * Set the boolean result for the logic formulation. This function can only be called by executable.
	 * */
	public void setResult(Boolean result);
}
