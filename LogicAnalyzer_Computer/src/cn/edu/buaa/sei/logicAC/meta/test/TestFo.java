package cn.edu.buaa.sei.logicAC.meta.test;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicExpression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.common.CommonLogicFactory;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Conjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Disjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Equivalence;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Implication;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Negation;

public class TestFo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LogicExpression x = (LogicExpression) create1();
			System.out.println(printLogicFormulation(x));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static LogicFormulation create1() throws Exception{
		LogicExpression expr = CommonLogicFactory.createConjunction();
		
		LogicVariable a = CommonLogicFactory.createLogicVariable("a");
		LogicVariable b = CommonLogicFactory.createLogicVariable("b");
		
		Conjunction op = (Conjunction) expr.getOperator();
		op.addOperand(a);
		op.addOperand(b);
		
		return expr;
	}
	
	public static String printLogicFormulation(LogicFormulation x) throws Exception{
		if(x==null)return null;
		
		if(x instanceof LogicExpression)return printLogicExpression((LogicExpression) x);
		else if(x instanceof LogicVariable)return printLogicVariable((LogicVariable) x);
		else throw new Exception("Unknown logic formulation type: "+x.getClass().getName());
	}

	private static String printLogicVariable(LogicVariable x) {
		if(x==null)return null;
		return x.getName();
	}

	private static String printLogicExpression(LogicExpression x) throws Exception {
		// TODO Auto-generated method stub
		if(x==null)return null;
		
		LogicOperator op = x.getOperator();
		if(op==null)
			throw new Exception("Null Operator is invalid expression");
		if(op instanceof Conjunction){return printConjunction((Conjunction) op);}
		else if(op instanceof Disjunction){return printDisjunction((Disjunction) op);}
		else if(op instanceof Negation){return printNegation((Negation) op);}
		else if(op instanceof Implication){return printImplication((Implication) op);}
		else if(op instanceof Equivalence){return printEquivalence((Equivalence) op);}
		else throw new Exception("Unknown Operator: "+op.getClass().getName());
	}

	private static String printEquivalence(Equivalence op) throws Exception {
		if(op==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("(");
		code.append(printLogicFormulation(op.getLeft()));
		code.append("<-->");
		code.append(printLogicFormulation(op.getRight()));
		code.append(")");
		
		return code.toString();
	}

	private static String printImplication(Implication op) throws Exception {
		if(op==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("(");
		code.append(printLogicFormulation(op.getPrecondition()));
		code.append("-->");
		code.append(printLogicFormulation(op.getConclusion()));
		code.append(")");
		
		return code.toString();
	}

	private static String printNegation(Negation op) throws Exception {
		if(op==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("(!");
		code.append(printLogicFormulation(op.getOperand()));
		code.append(")");
		
		return code.toString();
	}

	private static String printDisjunction(Disjunction op) throws Exception {
		if(op==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("(");
		LogicFormulation[] list = op.getOperands();
		for(int i=0;i<op.getCurrentSize();i++){
			code.append(printLogicFormulation(list[i]));
			if(i!=op.getCurrentSize()-1)
				code.append("|");
		}
		code.append(")");
		
		return code.toString();
	}

	private static String printConjunction(Conjunction op) throws Exception {
		if(op==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("(");
		LogicFormulation[] list = op.getOperands();
		for(int i=0;i<op.getCurrentSize();i++){
			code.append(printLogicFormulation(list[i]));
			if(i!=op.getCurrentSize()-1)
				code.append("&");
		}
		code.append(")");
		
		return code.toString();
	}
	
}
