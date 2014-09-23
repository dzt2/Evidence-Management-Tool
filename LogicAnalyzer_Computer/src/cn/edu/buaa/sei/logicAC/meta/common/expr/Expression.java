package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;

public interface Expression extends ContextFreeComputable{
	public Operator getOperator();
}
