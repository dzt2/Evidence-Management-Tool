package cn.edu.buaa.sei.logicAC.meta.common.var;

import cn.edu.buaa.sei.logicAC.meta.common.ContextFreeComputable;

public interface Bindable extends ContextFreeComputable{
	public Object read() throws Exception;
	public void assign(Object val) throws Exception;
}
