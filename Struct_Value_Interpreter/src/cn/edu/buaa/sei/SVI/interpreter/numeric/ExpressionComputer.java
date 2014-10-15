package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericExpression;

public interface ExpressionComputer extends Computer,IterationInterpreter{
	public Number interpret(NumericExpression expr) throws Exception;
}
