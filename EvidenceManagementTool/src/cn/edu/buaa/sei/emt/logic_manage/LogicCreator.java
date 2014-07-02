package cn.edu.buaa.sei.emt.logic_manage;

import java.util.List;

import cn.edu.buaa.sei.emt.logic.AtLeastQuantification;
import cn.edu.buaa.sei.emt.logic.AtMostOneQuantification;
import cn.edu.buaa.sei.emt.logic.AtMostQuantification;
import cn.edu.buaa.sei.emt.logic.Conjunction;
import cn.edu.buaa.sei.emt.logic.Disjunction;
import cn.edu.buaa.sei.emt.logic.Equivalence;
import cn.edu.buaa.sei.emt.logic.ExclusiveDisjunction;
import cn.edu.buaa.sei.emt.logic.ExistentialQuantification;
import cn.edu.buaa.sei.emt.logic.Implication;
import cn.edu.buaa.sei.emt.logic.LogicFactory;
import cn.edu.buaa.sei.emt.logic.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.NAND;
import cn.edu.buaa.sei.emt.logic.NOR;
import cn.edu.buaa.sei.emt.logic.Negation;
import cn.edu.buaa.sei.emt.logic.NumbericRangeQuantification;
import cn.edu.buaa.sei.emt.logic.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.Quantification;
import cn.edu.buaa.sei.emt.logic.SetVariable;
import cn.edu.buaa.sei.emt.logic.Statement;
import cn.edu.buaa.sei.emt.logic.UniversalQuantification;
import cn.edu.buaa.sei.emt.logic.Variable;

public class LogicCreator {
	
	public static final String CONJUNCTION = "&";
	public static final String DISJUNCTION = "|";
	public static final String EQUIVALENCE = "<-->";
	public static final String NEGATION = "!";
	public static final String EXDISJUNCTION = "~";
	public static final String IMPLICATION = "-->";
	public static final String N_AND = "NAND";
	public static final String N_OR = "NOR";
	
	
	
	/*
	 * Creating AtomicLogicFormulation 
	 */
	public static PropositionVariable createPropositionVariable(String name,String statement){
		if(name==null)return null;
		PropositionVariable proposition = LogicFactory.createPropositionVariable();
		
		proposition.setName(name);
		
		setStatement(proposition,statement);
		/*if(statement!=null){
			Statement stmt = LogicFactory.createStatement();
			stmt.setContent(statement);
			proposition.setStatement(stmt);
		}*/
		
		return proposition;
	}
	
	public static PredicateFormulation createPredicate(String name,String statement,List<Variable> arguments){
		if(name==null||arguments==null)return null;
		PredicateFormulation formulation = LogicFactory.createPredicateFormulation();
		
		formulation.setName(name);
		
		for(Variable var:arguments)
			formulation.getArguments().add(var);
		
		/*if(statement!=null){
			Statement stmt = LogicFactory.createStatement();
			stmt.setContent(statement);
			formulation.setStatement(stmt);
		}*/
		setStatement(formulation,statement);
		
		return formulation;
	}

	
	/*
	 *	Create LogicOperation 
	 */	
	public static Conjunction createConjunction(String name, String statement,List<LogicFormulation> operators){
		if(name==null||operators==null)return null;
		Conjunction conjunction = LogicFactory.createConjunction();
		
		/*if(statement!=null){
			Statement stmt = LogicFactory.createStatement();
			stmt.setContent(statement);
			conjunction.setStatement(stmt);
		}*/
		setStatement(conjunction,statement);
		
		for(LogicFormulation formulation:operators)
			conjunction.getOperators().add(formulation);
		
		conjunction.setName(name);
		return conjunction;
	}
	
	public static Disjunction createDisjunction(String name,String statement,List<LogicFormulation> operators){
		if(name==null||operators==null)return null;
		Disjunction disjunction = LogicFactory.createDisjunction();
		
		setStatement(disjunction,statement);
		
		for(LogicFormulation formulation:operators)
			disjunction.getOperators().add(formulation);
		
		disjunction.setName(name);
		return disjunction;
	}

	public static Negation createNegation(String name, String statement, LogicFormulation formulation){
		if(name==null||formulation==null)return null;
		Negation negation = LogicFactory.createNegation();
		
		setStatement(negation,statement);
		negation.setFormulation(formulation);
		
		negation.setName(name);
		return negation;
	}

	public static ExclusiveDisjunction createExclusiveDisjunction(String name, String statement, LogicFormulation op1, LogicFormulation op2){
		if(name==null||op1==null||op2==null)return null;
		ExclusiveDisjunction eor = LogicFactory.createExclusiveDisjunction();
		
		setStatement(eor, statement);
		eor.setOp1(op1);
		eor.setOp2(op2);
		
		eor.setName(name);
		return eor; 
	}

	public static Equivalence createEquivalence(String name, String statement, LogicFormulation op1, LogicFormulation op2){
		if(name==null||op1==null||op2==null)return null;
		Equivalence eq = LogicFactory.createEquivalence();
		
		setStatement(eq,statement);
		eq.setOp1(op1);
		eq.setOp2(op2);
		
		eq.setName(name);
		return eq;
	}
	
	public static Implication createImplication(String name, String statement, LogicFormulation antecident, LogicFormulation consequent){
		if(name==null||antecident==null||consequent==null)return null;
		Implication implication = LogicFactory.createImplication();
		
		setStatement(implication,statement);
		implication.setOp1(antecident); implication.setOp2(consequent);
		implication.setAntecedent(antecident);
		implication.setConsequent(consequent);
		
		implication.setName(name);
		return implication;
	}

	public static NAND createNAND(String name, String statement, LogicFormulation op1, LogicFormulation op2){
		if(name==null||op1==null||op2==null)return null;
		NAND nand = LogicFactory.createNAND();
		
		setStatement(nand,statement);
		nand.setOp1(op1);
		nand.setOp2(op2);
		
		nand.setName(name);
		return nand;
		
	}
	
	public static NOR createNOR(String statement, LogicFormulation op1, LogicFormulation op2){
		if(op1==null||op2==null)return null;
		
		NOR nor = LogicFactory.createNOR();
		setStatement(nor,statement);
		nor.setOp1(op1); nor.setOp2(op2);
		
		
		nor.setName(N_OR);
		return nor;
	}
	
	/*
	 *	Create Logic Quantification 
	 */
	public static void setQuantificationVariable(String var, String domain, Quantification quantification){
		if(quantification==null)return;
		quantification.getVariable().setName(var);
		quantification.getDomain().setName(domain);
	}
	
	public static UniversalQuantification createUniversal(String name, String statement,LogicFormulation formulation){
		if(name==null||formulation==null)return null;
		
		UniversalQuantification q = LogicFactory.createUniversalQuantification();
		q.setName(name);
		setStatement(q,statement);
		q.setScope(formulation);
		
		Variable x = LogicFactory.createIndividualVariable();
		SetVariable domain = LogicFactory.createSetVariable();
		q.setVariable(x);
		q.setDomain(domain);
		
		return q;
	}
	
	public static AtLeastQuantification createAtLeastQuantification(String name,String statement, LogicFormulation formulation, int n){
		if(name==null||formulation==null||n<0)return null;
		
		AtLeastQuantification q = LogicFactory.createAtLeastQuantification();
		
		q.setName(name); q.setScope(formulation); setStatement(q, statement); q.setLower_bound(n);
		
		q.setVariable(LogicFactory.createIndividualVariable());
		q.setDomain(LogicFactory.createSetVariable());
		
		return q;
	}

	public ExistentialQuantification createExistential(String name,String statement, LogicFormulation formulation){
		if(name==null||formulation==null)return null;
		ExistentialQuantification q = LogicFactory.createExistentialQuantification();
		
		q.setName(name);q.setScope(formulation);setStatement(q,statement); q.setLower_bound(1);
		
		q.setVariable(LogicFactory.createIndividualVariable());
		q.setDomain(LogicFactory.createSetVariable());
		
		return q;
	}

	public static AtMostQuantification createAtMostQuantification(String name,String statement,LogicFormulation formulation,int n){
		if(name==null||formulation==null)return null;
		AtMostQuantification q = LogicFactory.createAtMostQuantification();
		
		q.setName(name);q.setScope(formulation);setStatement(q, statement);q.setUpper_bound(n);
		q.setVariable(LogicFactory.createIndividualVariable());
		q.setDomain(LogicFactory.createSetVariable());
		
		return q;
	}
	
	public static AtMostOneQuantification createAtMostOneQuantification(String name,String statement,LogicFormulation formulation){
		if(name==null||formulation==null)return null;
		AtMostOneQuantification q = LogicFactory.createAtMostOneQuantification();
		
		q.setName(name);q.setScope(formulation);setStatement(q, statement);q.setUpper_bound(1);
		q.setVariable(LogicFactory.createIndividualVariable());
		q.setDomain(LogicFactory.createSetVariable());
		
		return q;
	}
	
	public static NumbericRangeQuantification createNumbericQuantification(String name,String statement,LogicFormulation formulation,int lower,int upper){
		if(name==null||formulation==null)return null;
		NumbericRangeQuantification q = LogicFactory.createNumbericRangeQuantification();
		
		q.setName(name);q.setScope(formulation);setStatement(q,statement);q.setUpper_bound(upper);q.setLower_bound(lower);
		q.setVariable(LogicFactory.createIndividualVariable());
		q.setDomain(LogicFactory.createSetVariable());
		
		return q;
	}
	
	private static void setStatement(LogicFormulation formulation, String statement){
		if(formulation==null||statement==null)return;
		Statement stmt = LogicFactory.createStatement();
		stmt.setContent(statement);
		formulation.setStatement(stmt);
	}
	
}
