package cn.edu.buaa.sei.logicAC.meta.test;

import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicExpression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.AtLeastQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.AtMostQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Existential;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Quantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.QuantifierOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RangeQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSet;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSetVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Universal;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.common.CommonLogicFactory;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.fo.FirstOrderFactory;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Conjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Disjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Equivalence;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Implication;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Negation;

public class TestFo {

	public static void main(String[] args) {
		try {
			LogicFormulation x = create3();
			
			System.out.println(printLogicFormulation(x));
			
			/*SequenceLogicComputer computer = LogicComputerFactory.createSequenceLogicComputer();
			computer.setTasks(new LogicFormulation[]{x});
			
			while(computer.hasNext()){
				LogicFormulation y = computer.executeOne();
				System.out.println("Ans["+y.hashCode()+"]: "+y.getResult());
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LogicFormulation create3() throws Exception{
		DiscourseDomain HLR = FirstOrderFactory.createDiscourseDomain("HLR");
		
		LogicFunctionTemplate accurateTemp = FirstOrderFactory.createLogicFunctionTemplate("accurate", new Variable[]{HLR.getIterator()});
		LogicFunctionTemplate detailedTemp = FirstOrderFactory.createLogicFunctionTemplate("detailed", new Variable[]{HLR.getIterator()});
		LogicFunctionTemplate unambiguousTemp = FirstOrderFactory.createLogicFunctionTemplate("unambiguous", new Variable[]{HLR.getIterator()});
		
		PredicateFunctionEnvironment env = FirstOrderFactory.createPredicateEnvironment(null);
		
		PredicateFunction accurate = FirstOrderFactory.createPredicate(accurateTemp, env);
		PredicateFunction detailed = FirstOrderFactory.createPredicate(detailedTemp, env);
		PredicateFunction unambiguous = FirstOrderFactory.createPredicate(unambiguousTemp, env);
		
		LogicExpression Lexpr = FirstOrderFactory.createConjunction();
		Conjunction op = (Conjunction) Lexpr.getOperator();
		op.addOperand(accurate);op.addOperand(detailed);op.addOperand(unambiguous);
		
		Quantifier x = FirstOrderFactory.createUniversal(HLR, Lexpr);
		
		
		
		return x;

	}
	
	public static LogicFormulation create1() throws Exception{
		LogicVariable a = CommonLogicFactory.createLogicVariable("a");
		LogicVariable b = CommonLogicFactory.createLogicVariable("b");
		LogicVariable c = CommonLogicFactory.createLogicVariable("c");
		LogicVariable d = CommonLogicFactory.createLogicVariable("d");
		
		LogicExpression not_d = CommonLogicFactory.createNegation();
		Negation not_op = (Negation) not_d.getOperator();
		not_op.setOperand(d);
		
		LogicExpression or_c_d = CommonLogicFactory.createDisjunction();
		Disjunction or_op = (Disjunction) or_c_d.getOperator();
		or_op.addOperand(not_d);
		or_op.addOperand(c);
		
		LogicExpression and_a_b = CommonLogicFactory.createConjunction();
		Conjunction and_op = (Conjunction) and_a_b.getOperator();
		and_op.addOperand(a);
		and_op.addOperand(b);
		and_op.addOperand(or_c_d);
		
		a.assign(true);
		b.assign(true);
		d.assign(true);
		c.assign(false);
		
		return and_a_b;
		
	}
	
	public static LogicFormulation create2() throws Exception{
		DiscourseDomain HLR = FirstOrderFactory.createDiscourseDomain("HLR");
		DiscourseDomain LLR = FirstOrderFactory.createDiscourseDomain("LLR");
		
		LogicFunctionTemplate template = FirstOrderFactory.createLogicFunctionTemplate("trace", new Variable[]{HLR.getIterator(),LLR.getIterator()});
		PredicateFunctionEnvironment env = FirstOrderFactory.createPredicateEnvironment(null);
		PredicateFunction trace = FirstOrderFactory.createPredicate(template, env);
		
		Quantifier L = FirstOrderFactory.createExistential(LLR, trace);
		Quantifier P = FirstOrderFactory.createUniversal(HLR, L);
		
		Set<Object> hlrs = new HashSet<Object>();HLR.assign(hlrs);
		Set<Object> llrs = new HashSet<Object>();LLR.assign(llrs);
		
		hlrs.add("h1");hlrs.add("h2");hlrs.add("h3");hlrs.add("h4");
		llrs.add("l1");llrs.add("l2");llrs.add("l3");llrs.add("l4");llrs.add("l5");
		
		RelationSetVariable var = trace.getEnvironment().getRelationSetVariable();
		RelationSet rset = FirstOrderFactory.createRelationSet();
		
		rset.addRelation(new Object[]{"h1","l1"});
		rset.addRelation(new Object[]{"h1","l2"});
		rset.addRelation(new Object[]{"h2","l3"});
		rset.addRelation(new Object[]{"h3","l4"});
		//rset.addRelation(new Object[]{"h3","l5"});
		rset.addRelation(new Object[]{"h4","l5"});
		rset.addRelation(new Object[]{1,"st"});
		
		var.assign(rset);
		return P;
	}
	
	public static String printLogicFormulation(LogicFormulation x) throws Exception{
		if(x==null)return null;
		
		if(x instanceof LogicExpression)return printLogicExpression((LogicExpression) x);
		else if(x instanceof LogicVariable)return printLogicVariable((LogicVariable) x);
		else if(x instanceof Quantifier)return printQuantifier((Quantifier)x);
		else if(x instanceof LogicFunction)return printLogicFunction((LogicFunction)x);
		else throw new Exception("Unknown logic formulation type: "+x.getClass().getName());
	}

	private static String printLogicFunction(LogicFunction x) {
		if(x==null)return null;
		StringBuilder code = new StringBuilder();
		
		LogicFunctionTemplate template = x.getTemplate();
		code.append(template.getName()).append("(");
		Variable[] arguments = template.getArguments();
		for(int i=0;i<arguments.length;i++){
			code.append(arguments[i].getName());
			if(i!=arguments.length-1)
				code.append(", ");
		}
		code.append(")");
		
		return code.toString();
	}

	private static String printQuantifier(Quantifier x) throws Exception {
		if(x==null)return null;
		
		QuantifierOperator op = x.getOperator();
		
		StringBuilder code = new StringBuilder();
		
		if(op instanceof Universal)code.append("ALL(");
		else if(op instanceof Existential)code.append("EXIST(");
		else if(op instanceof AtLeastQuantifier)code.append("AtLeast(").append(((AtLeastQuantifier) op).getLowerBound()).append(",");
		else if(op instanceof AtMostQuantifier)code.append("AtMost(").append(((AtMostQuantifier) op).getUpperBound()).append(",");
		else if(op instanceof RangeQuantifier)code.append("Range([").append(((RangeQuantifier) op).getLowerBound()).
												append(",").append(((RangeQuantifier) op).getUpperBound()).append("],");
		else throw new Exception("Unknown QuantifierOperator type: "+op.getClass().getName());
		
		code.append(op.getDomain().getName()).append(",");
		code.append(printLogicFormulation(op.getScope()));
		code.append(")");
		
		return code.toString();
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
