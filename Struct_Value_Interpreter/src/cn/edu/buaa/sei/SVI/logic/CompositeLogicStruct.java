package cn.edu.buaa.sei.SVI.logic;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.extend.LogicStruct;

/**
 * <i>CompositeLogicStruct</i> is a composite <i>LogicStruct</i> with children.<br>
 * It could be: <b>LogicExpression {<i>LogicOperator</i>}</b> or <b>LogicFunction {LogicFunctionTemplate}</b> 
 * */
public interface CompositeLogicStruct extends LogicStruct,CompositeStruct{
}
