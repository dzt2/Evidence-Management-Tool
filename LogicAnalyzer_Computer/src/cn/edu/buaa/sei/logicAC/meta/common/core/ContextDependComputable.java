package cn.edu.buaa.sei.logicAC.meta.common.core;

public interface ContextDependComputable extends Computable{
	public Context getContext();
	public void setContext(Context context) throws Exception;
}
