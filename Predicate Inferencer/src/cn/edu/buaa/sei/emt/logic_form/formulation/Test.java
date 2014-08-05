package cn.edu.buaa.sei.emt.logic_form.formulation;

import java.util.HashSet;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.lmf.LMFContext;

public class Test {
	public static void main(String[] args){
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
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
	
	
}
