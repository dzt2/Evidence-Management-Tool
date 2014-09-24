package cn.edu.buaa.sei.logicAC.meta.common.core;

public interface Executable {
	public Computable[] getComputedComponents();
	public void setComputedComponents(Computable[] components);
	
	public void execute() throws Exception;
}
