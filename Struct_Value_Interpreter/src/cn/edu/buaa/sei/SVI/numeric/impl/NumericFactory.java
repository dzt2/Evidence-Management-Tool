package cn.edu.buaa.sei.SVI.numeric.impl;

import cn.edu.buaa.sei.SVI.core.StructArray;
import cn.edu.buaa.sei.SVI.core.extend.NumericStruct;
import cn.edu.buaa.sei.SVI.core.function.Context;
import cn.edu.buaa.sei.SVI.core.function.FunctionBody;
import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.numeric.Addition;
import cn.edu.buaa.sei.SVI.numeric.Division;
import cn.edu.buaa.sei.SVI.numeric.Mod;
import cn.edu.buaa.sei.SVI.numeric.Multiplication;
import cn.edu.buaa.sei.SVI.numeric.NaturalVariable;
import cn.edu.buaa.sei.SVI.numeric.NumericExpression;
import cn.edu.buaa.sei.SVI.numeric.NumericFunction;
import cn.edu.buaa.sei.SVI.numeric.NumericFunctionTemplate;
import cn.edu.buaa.sei.SVI.numeric.RationalVariable;
import cn.edu.buaa.sei.SVI.numeric.RealVariable;
import cn.edu.buaa.sei.SVI.numeric.Substraction;
import cn.edu.buaa.sei.SVI.numeric.ZIntegerVariable;

public class NumericFactory {
	public static NaturalVariable createNaturalVariable(String name) throws Exception{
		return new NaturalVariableImpl(name);
	}
	public static ZIntegerVariable createZIntegerVariable(String name) throws Exception{
		return new ZIntegerVariableImpl(name);
	}
	public static RationalVariable createRationalVariable(String name) throws Exception{
		return new RationalVariableImpl(name);
	}
	public static RealVariable createRealVariable(String name) throws Exception{
		return new RealVariableImpl(name);
	}
	
	public static NumericExpression createAddition(NumericStruct left,
			NumericStruct right) throws Exception{
		Addition op = new AdditionImpl(left,right,new StructArray());
		return new NumericExpressionImpl(op,new StructArray());
	}
	public static NumericExpression createSubstract(NumericStruct left,
			NumericStruct right) throws Exception{
		Substraction op = new SubstractionImpl(left,right,new StructArray());
		return new NumericExpressionImpl(op,new StructArray());
	}
	public static NumericExpression createMultiplication(NumericStruct left,
			NumericStruct right) throws Exception{
		Multiplication op = new MultiplicationImpl(left,right,new StructArray());
		return new NumericExpressionImpl(op,new StructArray());
	}
	public static NumericExpression createMod(NumericStruct left,
			NumericStruct right) throws Exception{
		Mod op = new ModImpl(left,right,new StructArray());
		return new NumericExpressionImpl(op,new StructArray());
	}
	public static NumericExpression createDivision(NumericStruct left,
			NumericStruct right) throws Exception{
		Division op = new DivisionImpl(left,right,new StructArray());
		return new NumericExpressionImpl(op,new StructArray());
	}
	
	public static NumericFunctionTemplate createNaturalFunctionTemplate(String name,
			Variable[] arguments) throws Exception{
		return new NumericFunctionTemplateImpl(name,arguments,
				new NaturalVariableImpl(NumericFunctionTemplateImpl.OUT_NAME),new StructArray());
	}
	public static NumericFunctionTemplate createZIntegerFunctionTemplate(String name,
			Variable[] arguments) throws Exception{
		return new NumericFunctionTemplateImpl(name,arguments,
				new ZIntegerVariableImpl(NumericFunctionTemplateImpl.OUT_NAME),new StructArray());
	}
	public static NumericFunctionTemplate createRationalFunctionTemplate(String name,
			Variable[] arguments) throws Exception{
		return new NumericFunctionTemplateImpl(name,arguments,
				new RationalVariableImpl(NumericFunctionTemplateImpl.OUT_NAME),new StructArray());
	}
	public static NumericFunctionTemplate createRealFunctionTemplate(String name,
			Variable[] arguments) throws Exception{
		return new NumericFunctionTemplateImpl(name,arguments,
				new RealVariableImpl(NumericFunctionTemplateImpl.OUT_NAME),new StructArray());
	}
	public static NumericFunctionTemplate createVoidFunctionTemplate(String name,
			Variable[] arguments) throws Exception{
		return new NumericFunctionTemplateImpl(name,arguments,
				null,new StructArray());
	}
	
	public static NumericFunction createNumericFunction(NumericFunctionTemplate template,Context context,FunctionBody body) throws Exception{
		NumericFunction function = new NumericFunctionImpl(template,new StructArray());
		function.setContext(context);
		function.setBody(body);
		return function;
	}
}
