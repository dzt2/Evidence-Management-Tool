package cn.edu.buaa.sei.SVI.struct.logic.test;

import cn.edu.buaa.sei.SVI.interpreter.core.InterpreterRegister;
import cn.edu.buaa.sei.SVI.interpreter.core.RegisterMachine;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
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
import cn.edu.buaa.sei.SVI.struct.core.Struct;
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

public class Test2 {

	static Constructor constructor;
	static InterpreterRegister register=RegisterMachine.register;
	
	public static void main(String[] args) {
		try {
			register();
			Struct struct = create();
			printStruct(struct);
			Boolean result = interpret(struct);
			System.out.println("Result: "+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void register() throws Exception{
		register.register(LogicVariable.class, VariableInferencerImpl.class);
		register.register(LogicExpression.class, ExpressionInferencerImpl.class);
		register.register(Conjunction.class, ConjunctionInferencerImpl.class);
		register.register(Disjunction.class, DisjunctionInferencerImpl.class);
		register.register(Negation.class, NegationInferencerImpl.class);
		register.register(Implication.class, ImplicationInferencerImpl.class);
		register.register(Equivalence.class, EquivalenceInferencerImpl.class);
		register.register(Universal.class, UniversalInferencerImpl.class);
		register.register(Existential.class, ExistentialInferencerImpl.class);
		register.register(AtLeast.class, AtMostInferencerImpl.class);
		register.register(AtMost.class, AtMostInferencerImpl.class);
		register.register(Between.class, BetweenInferencerImpl.class);
		register.register(LogicFunction.class, FunctionInferencerImpl.class);
	}
	
	public static Struct create() throws Exception{
		return constructor.create();
	}
	public static void printStruct(Struct struct){
		System.out.println(struct.toString());
	}
	public static Boolean interpret(Struct struct)throws Exception{
		Inferencer inferencer = (Inferencer) register.get(struct);
		System.out.println("Getting Inferencer: "+inferencer.getClass().getName()+" {"+inferencer.hashCode()+"}");
		return (Boolean) inferencer.interpret(struct);
	}
	
}
