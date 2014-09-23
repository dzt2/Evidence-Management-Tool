package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;

public interface Operator extends ContextFreeComputable{
	public Computable[] getChildren();
}
