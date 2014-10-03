package cn.edu.buaa.sei.logicAC.meta.logic.computer;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public interface LogicComputerUnit {
	public static enum Compute_State {COMPUTABLE,NOT_READY,CIRCLE,UNKNOWN};
	/**
	 * Compute the formulation and set its result, if not computable, return the state.<br>
	 * Return COMPUTABLE: if x is computable. <br>
	 * Return NOT_READY:  if elements in x has not been computed for their results.<br>
	 * Return CIRCLE:	  if there exists circle in the formulation which is dangerous for the computation.<br>
	 * Return UNKNOWN:	  if the computer does not understand what means to that formulation x.<br>
	 * */
	public Compute_State compute(LogicFormulation x);
}
