package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.var.FreeVariable;
import cn.edu.buaa.sei.logicAC.meta.common.var.base.SetVariable;

public interface DiscourseDomain extends SetVariable{
	public FreeVariable getIterator();
}
