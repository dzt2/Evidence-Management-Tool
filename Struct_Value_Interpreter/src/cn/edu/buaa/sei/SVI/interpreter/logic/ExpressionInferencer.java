package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;

/**
 * ExpressionInferencer is the inferencer to inference result of logic expression.
 * */
public interface ExpressionInferencer extends Inferencer,IterationInterpreter{
	/**
	 * Inference a given logic expression and return the boolean result.
	 * */
	public Boolean interpret(LogicExpression expr) throws Exception;
}
