package cn.edu.buaa.sei.SVI.interpreter.logic;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.InterpreterRegister;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.AtMostInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.BetweenInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.ConjunctionInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.DisjunctionInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.EquivalenceInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.ExistentialInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.ExpressionInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.FunctionInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.ImplicationInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.NegationInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.UniversalInferencerImpl;
import cn.edu.buaa.sei.SVI.interpreter.logic.impl.VariableInferencerImpl;
import cn.edu.buaa.sei.SVI.struct.core.variable.Bindable;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.logic.AtLeast;
import cn.edu.buaa.sei.SVI.struct.logic.AtMost;
import cn.edu.buaa.sei.SVI.struct.logic.Between;
import cn.edu.buaa.sei.SVI.struct.logic.Conjunction;
import cn.edu.buaa.sei.SVI.struct.logic.Disjunction;
import cn.edu.buaa.sei.SVI.struct.logic.Equivalence;
import cn.edu.buaa.sei.SVI.struct.logic.Existential;
import cn.edu.buaa.sei.SVI.struct.logic.Implication;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicVariable;
import cn.edu.buaa.sei.SVI.struct.logic.Negation;
import cn.edu.buaa.sei.SVI.struct.logic.Universal;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;

public class Test {

	static InterpreterRegister register;
	
	public static void main(String[] args) {
		try {
			register();
			test2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static InterpreterRegister register() throws Exception{
		register = Interpreter.register;
		register.register((Class)LogicVariable.class, (Class)VariableInferencerImpl.class);
		register.register((Class)LogicExpression.class, (Class)ExpressionInferencerImpl.class);
		register.register((Class)Conjunction.class, (Class)ConjunctionInferencerImpl.class);
		register.register((Class)Disjunction.class, (Class)DisjunctionInferencerImpl.class);
		register.register((Class)Negation.class, (Class)NegationInferencerImpl.class);
		register.register((Class)Implication.class, (Class)ImplicationInferencerImpl.class);
		register.register((Class)Equivalence.class, (Class)EquivalenceInferencerImpl.class);
		register.register((Class)Universal.class, (Class)UniversalInferencerImpl.class);
		register.register((Class)Existential.class, (Class)ExistentialInferencerImpl.class);
		register.register(AtLeast.class, AtMostInferencerImpl.class);
		register.register(AtMost.class, AtMostInferencerImpl.class);
		register.register(Between.class, BetweenInferencerImpl.class);
		register.register((Class)LogicFunction.class, (Class)FunctionInferencerImpl.class);
		return register;
	}

	public static void test1() throws Exception{
		LogicVariable var = LogicFactory.createLogicVariable("a");
		Variable b = var;
		Bindable a = b;
		
		System.out.println(var.getClass().getCanonicalName());
		System.out.println(b.getClass().getCanonicalName());
		System.out.println(a.getClass().getCanonicalName());
	}
	
	public static void test2() throws Exception{
		LogicVariable a = LogicFactory.createLogicVariable("a");
		LogicVariable b = LogicFactory.createLogicVariable("b");
		LogicExpression e = LogicFactory.createImplication(a, b);
		
		a.assign(false); b.assign(true);
		
		Inferencer ai = (Inferencer) register.get(a);
		Inferencer bi = (Inferencer) register.get(b);
		Inferencer ei = (Inferencer) register.get(e);
		
		System.out.println(e.toString());
		System.out.println(printInterpreter(ai));
		System.out.println(printInterpreter(bi));
		System.out.println(printInterpreter(ei));
		
		System.out.println("a: "+ai.interpret(a));
		System.out.println("b: "+bi.interpret(b));
		System.out.println("e: "+ei.interpret(e));
	}
	
	public static String printInterpreter(Interpreter interpreter){
		if(interpreter==null)return null;
		else return interpreter.getClass().getName()+"{"+interpreter.hashCode()+"}";
	}
}
