package cn.edu.buaa.sei.SVI.interpreter.numeric;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.InterpreterRegister;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.AdditionComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.CardinalityComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.DivisionComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.ExpressionComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.FunctionComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.ModComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.MultiplicationComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.SubstractionComputerImpl;
import cn.edu.buaa.sei.SVI.interpreter.numeric.impl.VariableComputerImpl;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.group.Cardinality;
import cn.edu.buaa.sei.SVI.struct.numeric.Addition;
import cn.edu.buaa.sei.SVI.struct.numeric.Division;
import cn.edu.buaa.sei.SVI.struct.numeric.Mod;
import cn.edu.buaa.sei.SVI.struct.numeric.Multiplication;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericExpression;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunction;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.Substraction;
import cn.edu.buaa.sei.SVI.struct.numeric.impl.NumericFactory;

public class Test {

	static InterpreterRegister register;
	
	public static void main(String[] args) {
		try {
			register();
			Struct p = create1();
			System.out.println(p.toString());
			
			Interpreter interpreter = register.get(p);
			System.out.println("result: "+interpreter.interpret(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void register() throws Exception{
		register = Interpreter.register;
		register.register(Addition.class, AdditionComputerImpl.class);
		register.register(Substraction.class, SubstractionComputerImpl.class);
		register.register(Multiplication.class, MultiplicationComputerImpl.class);
		register.register(Division.class, DivisionComputerImpl.class);
		register.register(Mod.class, ModComputerImpl.class);
		register.register(Cardinality.class, CardinalityComputerImpl.class);
		register.register(NumericExpression.class, ExpressionComputerImpl.class);
		register.register(NumericVariable.class, VariableComputerImpl.class);
		register.register(NumericFunction.class, FunctionComputerImpl.class);
	}
	
	public static Struct create1() throws Exception{
		NumericVariable x = NumericFactory.createZIntegerVariable("x");
		NumericVariable y = NumericFactory.createZIntegerVariable("y");
		NumericVariable z = NumericFactory.createZIntegerVariable("z");
		
		NumericExpression t1 = NumericFactory.createAddition(x, y);
		NumericExpression t21 = NumericFactory.createMultiplication(x, z);
		NumericExpression t22 = NumericFactory.createMultiplication(y, y);
		NumericExpression t2 = NumericFactory.createDivision(t21,t22);
		
		x.assign(15); y.assign(1); z.assign(6);
		
		return NumericFactory.createSubstract(t1, t2);
	}
	
}
