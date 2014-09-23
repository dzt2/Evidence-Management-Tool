package cn.edu.buaa.sei.logicAC.meta.common;

public interface ContextDependComputable extends Computable{
	public void setContext(Context context);
	public Context getContext();
}
