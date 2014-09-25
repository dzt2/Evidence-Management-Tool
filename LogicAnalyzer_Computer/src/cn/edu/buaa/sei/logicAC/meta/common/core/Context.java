package cn.edu.buaa.sei.logicAC.meta.common.core;

import java.util.Iterator;

/**
 * Context provide environment information for executing the computation of target computable.
 * */
public interface Context {
	/**
	 * Return whether a computable is set in the context.
	 * @exception {null} - unit is null.
	 * */
	public boolean containComputableUnit(ContextDependComputable unit);
	/**
	 * Add the context to a new target computable.<br>
	 * 1) The context of the target computable is this one --> Do nothing.<br>
	 * 2) The context of the target computable is not null --> Remove from the original context at first. <br>
	 * 3) The target computable is null --> exception.
	 * @exception Exception -- Null unit 
	 * */
	public void addComputableUnit(ContextDependComputable unit) throws Exception;
	/**
	 * Remove the context from the target computable.<br>
	 * 1) The context of the target computable is this one --> just remove and set its context null.<br>
	 * 2) The context of the target computable is not this one --> exception
	 * 3) The target computable is null. --> exception
	 * */
	public void removeComputableUnit(ContextDependComputable unit) throws Exception;
	/**
	 * Return all the computable in the context.
	 * */
	public Iterator<ContextDependComputable> getComputableUnits();
}
