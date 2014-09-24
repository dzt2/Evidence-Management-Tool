package cn.edu.buaa.sei.logicAC.meta.logic.fo;
import cn.edu.buaa.sei.logicAC.meta.common.context.NormativeParameterList;

public interface UnaryPredicateTemplate extends PredicateTemplate{
	/**
	 * Set the parameter list of function. {must be normative}
	 * @exception Exception plist==null
	 * @exception Exception plist not instance of NormativeParameterList
	 * @exception Exception plist.out is not BooleanVariable
	 * @exception Exception plist.arguments.size() != 1
	 * */
	public void setParameters(NormativeParameterList plist) throws Exception;
}
