package cn.edu.buaa.sei.logicAC.meta.common.var;

import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;
import cn.edu.buaa.sei.logicAC.meta.common.core.ProtoComputable;

/**
 * Bindable is a pointer which refers/binds to the target value in memory space.<br>
 * Bindable is computable for it could be computed {read the value}<br>
 * Bindable is Context-Free since its value depends on the address it ponints to.<br>
 * Bindable is Prototype since it has not structure and is the most simple & basic unit of computable.
 * */
public interface Bindable extends ContextFreeComputable,ProtoComputable{
	/**
	 * Return the value pointed by this bindable.
	 * @exception Exception : the bindable points to null {invalid address}
	 * */
	public Object read() throws Exception;
	/**
	 * Set the bindable refers/binds to a target value.
	 * @exception Exception : set null to the bindable, leading it invalid.
	 * @exception Exception: set value incompatible with variable type [TypedVariable]
	 * */
	public void assign(Object val) throws Exception;
}
