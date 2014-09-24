package cn.edu.buaa.sei.logicAC.meta.common.function;

import cn.edu.buaa.sei.logicAC.meta.common.core.StructuralComputable;

/**
 * Function is a computable since we can compute a result (return) from it.<br>
 * Function is a structural computable since it is defined as some template {FunctionTemplate}.<br>
 * Function can be context-independent: ContextFreeFunction.<br>
 * Function can be context-dependent: CotnextDepandFunction.
 * */
public interface Function extends StructuralComputable{
	/**
	 * Return the template of function as its declaration.
	 * */
	public FunctionTemplate getTemplate();
}
