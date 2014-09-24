package cn.edu.buaa.sei.logicAC.meta.common.core;

/**
 * Executable is an executor to compute the computable (tasks) in a time-scheduling system.<br>
 * Any Executable could be configed with a list of tasks {computable} and
 *  after its execution, the task's result would be assigned.<br>
 * There are three kinds of executable:<br>
 * 	-- Sequence: from the first to the last -- FIFO<br>
 *  -- Selection: execute the one that is selected. -- Random<br>
 *  -- Concurrent: execute several of them at the same time.<br>
 * */
public interface Executable {
	/**
	 * Config the list of tasks [computable] to be computed in the executor.<br>
	 * Note that: all the tasks need to be ready {for example, configurated with a context} so that they could be computed.<br>
	 * Note that: it is better to group tasks that are relevant with each other so that the executor would compute them together fast.
	 * */
	public void setTasks(Computable[] tasks) throws Exception;
	/**
	 * Return the list of tasks that has been input into the executor at the beginning.
	 * */
	public Computable[] getTasks();
	/**
	 * Remove all the tasks in the list so that users could config new tasks to be computed.<br>
	 * Note that: it is better to call this function only after all tasks have been finished.
	 * */
	public void clear() throws Exception;
}
