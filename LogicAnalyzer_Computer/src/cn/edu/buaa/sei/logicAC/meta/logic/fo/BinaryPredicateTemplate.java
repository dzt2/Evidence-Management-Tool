package cn.edu.buaa.sei.logicAC.meta.logic.fo;

import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public interface BinaryPredicateTemplate extends PredicateTemplate{
	public void setInParameters(Variable left,Variable right) throws Exception;
	
	public boolean isDirect();
	public void setDirect(boolean isDirect);
}
