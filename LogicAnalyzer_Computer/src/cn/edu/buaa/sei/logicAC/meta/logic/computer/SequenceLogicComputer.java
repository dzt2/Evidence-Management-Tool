package cn.edu.buaa.sei.logicAC.meta.logic.computer;

import cn.edu.buaa.sei.logicAC.meta.common.runner.SequenceExecutable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public interface SequenceLogicComputer extends LogicComputer,SequenceExecutable{
	/**
	 * To execute the next logic formulation as computable task.<br>
	 * @exception Exception The next task is not computable.
	 * @return Return the next task which has been computed.
	 * */
	public LogicFormulation executeOne() throws Exception;
}
