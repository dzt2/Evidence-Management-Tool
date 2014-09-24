package cn.edu.buaa.sei.logicAC.meta.common.var;

import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;
import cn.edu.buaa.sei.logicAC.meta.common.core.ProtoComputable;

public interface Bindable extends ContextFreeComputable,ProtoComputable{
	public Object read() throws Exception;
	public void assign(Object val) throws Exception;
}
