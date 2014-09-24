package cn.edu.buaa.sei.logicAC.meta.common.core;

public interface Context {
	public boolean containComputableUnit(ContextDependComputable unit);
	public void addComputableUnit(ContextDependComputable unit) throws Exception;
	public void removeComputableUnit(ContextDependComputable unit) throws Exception;
	public Computable[] getComputableUnits();
}
