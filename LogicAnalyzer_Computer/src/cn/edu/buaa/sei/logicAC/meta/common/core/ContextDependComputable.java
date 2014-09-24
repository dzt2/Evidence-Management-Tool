package cn.edu.buaa.sei.logicAC.meta.common.core;

/**
 * ContextDependComputable is the computable whose computation depends on environment [context].<br>
 * 1) Function depends on environment variables, such as external data. <br>
 * 2) Predicate function depends on relation table in environment context. <br>
 * 3) Expression is not function because the computation is certain not depending on other information.
 * */
public interface ContextDependComputable extends Computable{
	/**
	 * Return the environment context in which the computable is going to be solved.
	 * */
	public Context getContext();
	/**
	 * Set the environment in which the computable is going to be solved.
	 * */
	public void setContext(Context context) throws Exception;
}
