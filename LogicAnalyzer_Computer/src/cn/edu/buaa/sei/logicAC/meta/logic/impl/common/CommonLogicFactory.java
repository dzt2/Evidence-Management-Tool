package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicExpression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Conjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Disjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Equivalence;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Implication;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Negation;

public class CommonLogicFactory {
	public static LogicVariable createLogicVariable(String name) throws Exception{return new LogicVariableImpl(name);}
	public static LogicExpression createConjunction() throws Exception{
		Conjunction op = new ConjunctionImpl();
		return new LogicExpressionImpl(op);
	}
	public static LogicExpression createDisjunction() throws Exception{
		Disjunction op = new DisjunctionImpl();
		return new LogicExpressionImpl(op);
	}
	public static LogicExpression createImplication() throws Exception{
		Implication op = new ImplicationImpl();
		return new LogicExpressionImpl(op);
	}
	public static LogicExpression createEquivalence() throws Exception{
		Equivalence op = new EquivalenceImpl();
		return new LogicExpressionImpl(op);
	}
	public static LogicExpression createNegation() throws Exception{
		Negation op = new NegationImpl();
		return new LogicExpressionImpl(op);
	}
	public static LogicFunctionTemplate createLogicFunctionTemplate(String name,Variable[] arguments) throws Exception{
		return new LogicFunctionTemplateImpl(name,arguments);
	}
}
