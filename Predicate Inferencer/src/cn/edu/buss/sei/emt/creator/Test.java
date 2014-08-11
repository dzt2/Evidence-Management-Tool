package cn.edu.buss.sei.emt.creator;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.emt.logic.predicate.compute.LogicPrinter;
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

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		test2();
	}
	
	public static void test1(){
		LogicCreator creator = new LogicCreator("creator");
		LogicFormulation p = form1(creator);
		
		LogicPrinter printer = new LogicPrinter();
		System.out.println(printer.printFormulation(p));
		
		String id = "P.A";
		LogicFormulation form = (LogicFormulation) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P._arg2";
		form = (LogicFormulation) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P.C";
		form = (LogicFormulation) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P._arg2.E";
		form = (LogicFormulation) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P.C.F.child";
		form = (LogicFormulation) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P";
		form = (LogicFormulation) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
	}
	public static void test2(){
		LogicCreator creator = new LogicCreator("creator");
		LogicFormulation p = form2(creator);
		
		LogicPrinter printer = new LogicPrinter();
		System.out.println(printer.printFormulation(p));
		
		String id = "R";
		ManagedObject obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.domain";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.X";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.Y";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope.P";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope._arg1";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope.P._arg0";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope.P.Y_iter";
		obj = (ManagedObject) LogicFormulationAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
	}
	
	public static LogicFormulation form1(LogicCreator creator){
		PropositionVariable g = creator.createPropositionVariable("G");
		PropositionVariable e = creator.createPropositionVariable("E");
		PropositionVariable d = creator.createPropositionVariable("D");
		PropositionVariable b = creator.createPropositionVariable("B");
		PropositionVariable a = creator.createPropositionVariable("A");
		
		LogicExpression f = creator.createNegation("F", g);
		List<LogicFormulation> cf = new ArrayList<LogicFormulation>();
		cf.add(d);cf.add(e);cf.add(f);
		LogicExpression c = creator.createDisjuntion("C",cf);
		
		cf.clear();
		cf.add(a);cf.add(b);cf.add(c);
		LogicExpression p = creator.createConjunction("P",cf);
		
		return p;
	}
	public static LogicFormulation form2(LogicCreator creator){
		DiscourseDomain X = creator.createDiscourseDomain("X");
		DiscourseDomain Y = creator.createDiscourseDomain("Y");
		
		List<Variable> pv = new ArrayList<Variable>();
		pv.add(X.getIter()); pv.add(Y.getIter());
		PredicateFormulation P = creator.createPredicate("P", pv);
		
		pv.clear(); pv.add(Y.getIter());
		PredicateFormulation Q = creator.createPredicate("Q", pv);
		
		List<LogicFormulation> es = new ArrayList<LogicFormulation>();
		es.add(P);es.add(Q);
		LogicExpression ey = creator.createConjunction(es);
		
		Existential py = creator.createExistential(Y, ey);
		Universal ux = creator.createUniversal("R", X, py);
		
		return ux;
	}
}
