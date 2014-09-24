package cn.edu.buaa.sei.logicAC.meta.common.core;

public interface Executable {
	public void setTasks(Computable[] tasks);
	public Computable[] getTasks();
}
