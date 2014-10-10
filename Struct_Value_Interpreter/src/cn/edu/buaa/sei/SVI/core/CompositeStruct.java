package cn.edu.buaa.sei.SVI.core;

/**
 * CompositeStruct <i>{abstract}</i> is a struct with structure.<br>
 * It could be: <b>Expression[Operator]</b>, <b>Function[FunctionTemplate|Context|FunctionBody]</b>
 * */
public interface CompositeStruct extends Struct{
	/**
	 * Return all the children structs of the CompositeStruct
	 * */
	public Struct[] getChildrenStructs();
}
