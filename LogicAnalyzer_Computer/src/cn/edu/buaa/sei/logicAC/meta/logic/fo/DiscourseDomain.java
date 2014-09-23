package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.Variable;

public interface DiscourseDomain {
	/**
	 * Return the iterator (perhaps a Free-Variable)
	 * */
	public Variable getIterator();
	
	public Set<?> read();
	public void assign(Set<?> val);
}
