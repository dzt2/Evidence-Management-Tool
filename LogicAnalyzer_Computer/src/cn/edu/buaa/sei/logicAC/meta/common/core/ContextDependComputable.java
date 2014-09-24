package cn.edu.buaa.sei.logicAC.meta.common.core;

public interface ContextDependComputable extends Computable{
	public void setContext(Context context) throws Exception;
	public Context getContext();
}
