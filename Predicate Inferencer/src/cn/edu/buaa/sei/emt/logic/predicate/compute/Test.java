package cn.edu.buaa.sei.emt.logic.predicate.compute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationFactory;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;
import cn.edu.buaa.sei.lmf.LMFContext;

public class Test {
	public static void main(String[] args){
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		LogicFormulation p = form4();
		LogicPrinter printer = new LogicPrinter();
		System.out.println(printer.printFormulation(p));
		
		LogicInferencer inferencer = new LogicInferencer();
		inferencer.setFormulation(p);
		
		Set<Bindable> vars = inferencer.getVariables();
		//System.out.println("============ Variables List ==============");
		List<PropositionVariable> pvars = new ArrayList<PropositionVariable>();
		for(Bindable var:vars)
			pvars.add((PropositionVariable) var);
		
		BooleanObject TRUE = LogicFormulationFactory.createBooleanObject();
		BooleanObject FALSE = LogicFormulationFactory.createBooleanObject();
		TRUE.setBool_val(true);FALSE.setBool_val(false);
		
		for(int i=0;i<16;i++){
			System.out.println("========= Iterator "+i+" =========");
			int i1 = i%2;
			int i2 = (i/2)%2;
			int i3 = (i/4)%2;
			int i4 = (i/8)%2;
			
			System.out.println("X:= ["+i1+", "+i2+", "+i3+", "+i4+"]");
			
			if(i1!=0)LogicAssigner.assignPropositionVariable(pvars.get(0), TRUE);
			else LogicAssigner.assignPropositionVariable(pvars.get(0), FALSE);
			
			if(i2!=0)LogicAssigner.assignPropositionVariable(pvars.get(1), TRUE);
			else LogicAssigner.assignPropositionVariable(pvars.get(1), FALSE);
			
			if(i3!=0)LogicAssigner.assignPropositionVariable(pvars.get(2), TRUE);
			else LogicAssigner.assignPropositionVariable(pvars.get(2), FALSE);
			
			if(i4!=0)LogicAssigner.assignPropositionVariable(pvars.get(3), TRUE);
			else LogicAssigner.assignPropositionVariable(pvars.get(3), FALSE);
			
			System.out.println("Ready for that? "+inferencer.prepare_inference());
			System.out.println("Y:= "+inferencer.inference());
			
		}
		
	}
	
	public static void test1(){
		LogicSpace lspace = new LogicSpace("test");
		PropositionVariable a = lspace.createPropositionVariable("a");
		PropositionVariable b = lspace.createPropositionVariable("b");
		PropositionVariable c = lspace.createPropositionVariable("c");
		PropositionVariable d = lspace.createPropositionVariable("d");
		PropositionVariable e = lspace.createPropositionVariable("e");
		
		LogicExpression g = lspace.createNegation("g", e);
		Set<LogicFormulation> fs = new HashSet<LogicFormulation>();
		fs.add(c); fs.add(d); fs.add(g);
		LogicExpression f = lspace.createDisjunction("f", fs);
		
		Set<LogicFormulation> gs = new HashSet<LogicFormulation>();
		gs.add(a);gs.add(b);gs.add(f);
		LogicExpression p = lspace.createConjunction("p", gs);
		
		LogicPrinter printer = new LogicPrinter();
		String pc = printer.printFormulation(p);
		System.out.println("P:= "+pc);
		
		String fc = printer.printFormulation(f);
		String gc = printer.printFormulation(g);
		
		System.out.println("F:= "+fc);
		System.out.println("G:= "+gc);
	}

	public static void test2(){
		VariableSpace vspace = new VariableSpace("vars");
		DiscourseDomain X = vspace.createDiscourseDomain("X");
		DiscourseDomain Y = vspace.createDiscourseDomain("Y");
		
		LogicSpace lspace = new LogicSpace("logic");
		List<Variable> vars = new ArrayList<Variable>();
		vars.add(X.getIter());vars.add(Y.getIter());
		PredicateFormulation A = lspace.createPredicateFormulation("A", vars);
		
		Existential Q = lspace.createExistential("Q", Y, A);
		Universal P = lspace.createUniversal("P", X, Q);
		
		LogicPrinter printer = new LogicPrinter();
		System.out.println("P:= "+printer.printFormulation(P));
	}
	
	public static void test3(){
		VariableSpace vspace = new VariableSpace("vars");
		DiscourseDomain X = vspace.createDiscourseDomain("X");
		DiscourseDomain Y = vspace.createDiscourseDomain("Y");
		//vspace.createPredicateFormulation("Q", null);
		
		List<Variable> avars = new ArrayList<Variable>();
		avars.add(X.getIter());avars.add(Y.getIter());
		PredicateFormulation A = vspace.createPredicateFormulation("A", avars);
		
		List<Variable> bvars = new ArrayList<Variable>();
		bvars.add(Y.getIter());
		PredicateFormulation B = vspace.createPredicateFormulation("B", bvars);
		
		LogicSpace lspace = new LogicSpace("logic");
		Set<LogicFormulation> lfs = new HashSet<LogicFormulation>();
		lfs.add(A);lfs.add(B);
		LogicExpression L = lspace.createConjunction("L", lfs);
		
		Existential Q = lspace.createExistential("Q", Y, L);
		Universal P = lspace.createUniversal("P", X, Q);
		
		LogicPrinter printer = new LogicPrinter();
		
		System.out.println("P:= "+printer.printFormulation(P));
		System.out.println("Q:= "+printer.printFormulation(Q));
		System.out.println("L:= "+printer.printFormulation(L));
		System.out.println("A:= "+printer.printFormulation(A));
		System.out.println("B:= "+printer.printFormulation(B));
	}
	
	public static LogicFormulation form1(){
		VariableSpace vspace = new VariableSpace("vars");
		DiscourseDomain X = vspace.createDiscourseDomain("X");
		DiscourseDomain Y = vspace.createDiscourseDomain("Y");
		//vspace.createPredicateFormulation("Q", null);
		
		List<Variable> avars = new ArrayList<Variable>();
		avars.add(X.getIter());avars.add(Y.getIter());
		PredicateFormulation A = vspace.createPredicateFormulation("A", avars);
		
		List<Variable> bvars = new ArrayList<Variable>();
		bvars.add(Y.getIter());
		PredicateFormulation B = vspace.createPredicateFormulation("B", bvars);
		
		LogicSpace lspace = new LogicSpace("logic");
		Set<LogicFormulation> lfs = new HashSet<LogicFormulation>();
		lfs.add(A);lfs.add(B);
		LogicExpression L = lspace.createConjunction("L", lfs);
		
		Existential Q = lspace.createExistential("Q", Y, L);
		Universal P = lspace.createUniversal("P", X, Q);
		return P;
	}
	public static LogicFormulation form2(){
		VariableSpace vspace = new VariableSpace("vars");
		DiscourseDomain X = vspace.createDiscourseDomain("X");
		DiscourseDomain Y = vspace.createDiscourseDomain("Y");
		
		LogicSpace lspace = new LogicSpace("logic");
		List<Variable> vars = new ArrayList<Variable>();
		vars.add(X.getIter());vars.add(Y.getIter());
		PredicateFormulation A = lspace.createPredicateFormulation("A", vars);
		
		Existential Q = lspace.createExistential("Q", Y, A);
		Universal P = lspace.createUniversal("P", X, Q);
		return P;
	}
	public static LogicFormulation form3(){
		LogicSpace lspace = new LogicSpace("test");
		PropositionVariable a = lspace.createPropositionVariable("a");
		PropositionVariable b = lspace.createPropositionVariable("b");
		PropositionVariable c = lspace.createPropositionVariable("c");
		PropositionVariable d = lspace.createPropositionVariable("d");
		PropositionVariable e = lspace.createPropositionVariable("e");
		
		LogicExpression g = lspace.createNegation("g", e);
		Set<LogicFormulation> fs = new HashSet<LogicFormulation>();
		fs.add(c); fs.add(d); fs.add(g);
		LogicExpression f = lspace.createDisjunction("f", fs);
		
		Set<LogicFormulation> gs = new HashSet<LogicFormulation>();
		gs.add(a);gs.add(b);gs.add(f);
		LogicExpression p = lspace.createConjunction("p", gs);
		
		return p;
	}
	public static LogicFormulation form4(){
		LogicSpace lspace = new LogicSpace("logic");
		PropositionVariable a = lspace.createPropositionVariable("A");
		PropositionVariable b = lspace.createPropositionVariable("B");
		PropositionVariable c = lspace.createPropositionVariable("C");
		PropositionVariable d = lspace.createPropositionVariable("D");
		
		LogicExpression e1 = lspace.createNegation("!d", d);
		
		Set<LogicFormulation> e2s = new HashSet<LogicFormulation>();
		e2s.add(c);e2s.add(e1);
		LogicExpression e2 = lspace.createDisjunction("c||e1", e2s);
		
		Set<LogicFormulation> ps = new HashSet<LogicFormulation>();
		ps.add(a);ps.add(b);ps.add(e2);
		LogicExpression p = lspace.createConjunction("p", ps);
		
		return p;
		
	}

}
