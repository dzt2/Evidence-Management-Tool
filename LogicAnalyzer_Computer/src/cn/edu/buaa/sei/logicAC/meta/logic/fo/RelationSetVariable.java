package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.var.TypedVariable;

public interface RelationSetVariable extends TypedVariable{
	/**
	 * Return the value pointed by this bindable.
	 * @exception Exception : the bindable points to null {invalid address}
	 * */
	public RelationSet read() throws Exception;
	/**
	 * Set the bindable refers/binds to a target value.
	 * @exception Exception : set null to the bindable, leading it invalid.
	 * */
	public void assign(RelationSet val) throws Exception;
}
