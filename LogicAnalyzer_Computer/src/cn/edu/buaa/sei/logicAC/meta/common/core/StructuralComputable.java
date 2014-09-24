package cn.edu.buaa.sei.logicAC.meta.common.core;

/**
 * StructuralComputable present the object to be computed with complex structure.<br>
 * For instance, expression and function are computable with structure:<br> 
 * 		1) formal with operator and operands,<br>
 *  	2) and latter with parameter list.<br>
 *  An opposite concept of StructuralComputable is ProtoComputable
 * */
public interface StructuralComputable extends Computable{
	/**
	 * Return the template of the computable. <br>
	 * Template presents the structural and components of the computable unit.
	 * */
	public Template getTemplate();
}
