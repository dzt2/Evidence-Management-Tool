package cn.edu.buaa.sei.logicAC.meta.common;

import java.util.List;

public interface Executable {
	public List<Computable> getComputedComponents();
	public boolean containComputedCompoenent(Computable component);
	public void addComputedComponent(Computable component);
	public void removeComputedComponent(Computable component);
	
	public void execute() throws Exception;
}
