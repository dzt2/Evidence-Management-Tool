package cn.edu.buaa.sei.logicAC.meta.logic.computer;

import cn.edu.buaa.sei.logicAC.meta.common.core.Executable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public interface LogicComputer extends Executable{
	/**
	 * Set the tasks that would be computed in the computer for next steps.<br>
	 * @exception Exception tasks==null
	 * @exception Exception tasks[i]==null
	 * @exception Exception tasks[i] in-computable
	 * */
	public void setTasks(LogicFormulation[] tasks) throws Exception;
	/**
	 * Return the list of tasks that has been input into the executor at the beginning.
	 * */
	public LogicFormulation[] getTasks();
}
