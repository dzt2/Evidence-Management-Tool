package cn.edu.buaa.sei.emt.logic.predicate.compute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.lmf.ManagedObject;
import cn.edu.buss.sei.emt.creator.LogicFormulationAccessor;

public class Test {
	public static void main(String[] args){
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		LogicFormulation f = form4();
		String path = "p"+LogicFormulationAccessor.SPLIT + LogicFormulationAccessor.ARG_PREFIX +  "0"
				+ LogicFormulationAccessor.SPLIT + LogicFormulationAccessor.ARG_PREFIX+"1";
		ManagedObject obj = (ManagedObject) LogicFormulationAccessor.getElementByName(path, f);
		
		System.out.println(path + "-->" + "Object Type: "+obj.type().getFullName());
		
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
		PropositionVariable a = lspace.createPropositionVariable("a");
		PropositionVariable b = lspace.createPropositionVariable("b");
		PropositionVariable c = lspace.createPropositionVariable("c");
		PropositionVariable d = lspace.createPropositionVariable("d");
		
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
