package cn.edu.buaa.sei.logicAC.meta.common.expr;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.core.Template;

public interface Operator extends Template{
	public Computable[] getChildren();
}
