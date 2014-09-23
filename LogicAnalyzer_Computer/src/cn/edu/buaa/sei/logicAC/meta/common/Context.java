package cn.edu.buaa.sei.logicAC.meta.common;

import java.util.List;

public interface Context {
	public void addComponent(Computable component);
	public boolean containComponent(Computable component);
	public void removeComponent(Computable component);
	public List<Computable> getComponents();
	
	public Context getParentContext();
	public void setParentContext(Context context);
}
