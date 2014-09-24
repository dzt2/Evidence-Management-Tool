package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.ContextFreeComputable;
import cn.edu.buaa.sei.logicAC.meta.common.core.StructuralComputable;

public interface Expression extends ContextFreeComputable,StructuralComputable{
	public Operator getOperator();
}
