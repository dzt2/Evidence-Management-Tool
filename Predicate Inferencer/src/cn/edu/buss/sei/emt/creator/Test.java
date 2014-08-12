package cn.edu.buss.sei.emt.creator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.sei.emt.computation.ComputableAnalyzer;
import cn.edu.buaa.sei.emt.computation.IMachine_Iterater;
import cn.edu.buaa.sei.emt.computation.InferenceMachine;
import cn.edu.buaa.sei.emt.computation.LogicPrinter;
import cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomain;
import cn.edu.buaa.sei.emt.logic.predicate.core.Existential;
import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpression;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.predicate.core.Universal;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;
import cn.edu.buaa.sei.emt.logic.predicate.core.Variable;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.lmf.ManagedObject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		assign3();
	}
	
	public static void test1(){
		LogicCreator creator = new LogicCreator("creator");
		LogicFormulation p = form1(creator);
		
		LogicPrinter printer = new LogicPrinter();
		System.out.println(printer.printFormulation(p));
		
		String id = "P.A";
		LogicFormulation form = (LogicFormulation) LogicAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P._arg2";
		form = (LogicFormulation) LogicAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P.C";
		form = (LogicFormulation) LogicAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P._arg2.E";
		form = (LogicFormulation) LogicAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P.C.F.child";
		form = (LogicFormulation) LogicAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
		
		id = "P";
		form = (LogicFormulation) LogicAccessor.getElementByName(id, p);
		System.out.println(id+" --> "+form.getName());
	}
	public static void test2(){
		LogicCreator creator = new LogicCreator("creator");
		LogicFormulation p = form2(creator);
		
		LogicPrinter printer = new LogicPrinter();
		System.out.println(printer.printFormulation(p));
		
		String id = "R";
		ManagedObject obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.domain";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.X";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.Y";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope.P";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope._arg1";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope.P._arg0";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
		System.out.println(id+"-->"+obj.type().getFullName());
		
		id = "R.scope.scope.P.Y_iter";
		obj = (ManagedObject) LogicAccessor.getElementByName(id, p);
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
	public static LogicFormulation form3(LogicCreator creator){
		DiscourseDomain HLR = creator.createDiscourseDomain("HLR");
		DiscourseDomain LLR = creator.createDiscourseDomain("LLR");
		List<Variable> vars = new ArrayList<Variable>();
		vars.add(HLR.getIter());vars.add(LLR.getIter());
		PredicateFormulation trace = creator.createPredicate("traceable", vars);
		
		Existential Q = creator.createExistential(LLR, trace);
		Universal P = creator.createUniversal("P", HLR, Q);
		
		return P;
	}
	
	
	
	public static void assign1(){
		LogicCreator creator = new LogicCreator("creator");
		
		LogicFormulation P = form1(creator);
		LogicPrinter printer = new LogicPrinter();
		
		System.out.println("Creating P: "+printer.printFormulation(P));
		
		BooleanObject TRUE = ValueCreator.getTrue();
		BooleanObject FALSE = ValueCreator.getFalse();
		
		Map<String,Value> map = new HashMap<String,Value>();
		
		map.put("P.A",TRUE);
		map.put("P._arg1", TRUE);
		map.put("P.C.D", FALSE);
		map.put("P._arg2.E", FALSE);
		map.put("P.C.F.G", FALSE);
		
		LogicValueMapper mapper = new LogicValueMapper(P,map);
		boolean flag = mapper.assign();
		
		System.out.println("Assignment: "+flag);
		
		/*LogicInferencer infer = new LogicInferencer();
		infer.setFormulation(P);
		Boolean result = infer.inference();
		
		System.out.println("Is that acceptable? "+result);*/
	}
	public static void assign2(){
		
	}
	@SuppressWarnings("static-access")
	public static void assign3(){
		LogicCreator creator = new LogicCreator("creator");
		LogicFormulation P = form3(creator);
		LogicPrinter printer = new LogicPrinter();
		
		System.out.println("Complete to construct P:"+printer.printFormulation(P));
		ValueCreator vcreator = new ValueCreator("value-space");
		
		LSet hlr_set = vcreator.createSet();
		LSet llr_set = vcreator.createSet();
		
		ValueModifier.appendSet(hlr_set, vcreator.createObject("hlr1"));
		ValueModifier.appendSet(hlr_set, vcreator.createObject("hlr2"));
		ValueModifier.appendSet(hlr_set, vcreator.createObject("hlr3"));
		ValueModifier.appendSet(hlr_set, vcreator.createObject("hlr4"));
		ValueModifier.appendSet(hlr_set, vcreator.createObject("hlr5"));
		
		ValueModifier.appendSet(llr_set, vcreator.createObject("llr1"));
		ValueModifier.appendSet(llr_set, vcreator.createObject("llr2"));
		ValueModifier.appendSet(llr_set, vcreator.createObject("llr3"));
		ValueModifier.appendSet(llr_set, vcreator.createObject("llr4"));
		
		System.out.println("\nCreating HLRs: "+hlr_set.getValues().size());
		for(LObject val:hlr_set.getValues())
			System.out.print(val.getId()+" ");
		System.out.println("\nCreating LLRs: "+llr_set.getValues().size());
		for(LObject val:llr_set.getValues())
			System.out.print(val.getId()+" ");
		
		LRelationSet trace_map = vcreator.createRelationSet();
		List<LObject> elements = new ArrayList<LObject>();
		
		elements.clear(); elements.add(hlr_set.getValues().get(0)); elements.add(llr_set.getValues().get(1));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));
		
		elements.clear(); elements.add(hlr_set.getValues().get(0)); elements.add(llr_set.getValues().get(2));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));
		
		elements.clear(); elements.add(hlr_set.getValues().get(1)); elements.add(llr_set.getValues().get(0));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));
		
		elements.clear(); elements.add(vcreator.getObject("hlr3")); elements.add(vcreator.getObject("llr3"));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));
		
		elements.clear(); elements.add(vcreator.getObject("hlr4")); elements.add(vcreator.getObject("llr1"));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));
		
		/*elements.clear(); elements.add(vcreator.getObject("hlr4")); elements.add(vcreator.getObject("llr2"));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));*/
		
		/*elements.clear(); elements.add(vcreator.getObject("hlr5")); elements.add(vcreator.getObject("llr3"));
		ValueModifier.appendLRelationSet(trace_map, vcreator.createRelation("traceable",elements));*/
		
		System.out.println("\n\nThe traceable relations: "+trace_map.getRelations().size());
		for(int i=0;i<trace_map.getRelations().size();i++){
			LRelation relation = trace_map.getRelations().get(i);
			String name = relation.getName();
			List<LObject> values = relation.getElements();
			
			StringBuilder code = new StringBuilder();
			code.append(name).append("(");
			for(int j=0;j<values.size();j++){
				code.append(values.get(j).getId());
				if(j<values.size()-1)
					code.append(",");
			}
			code.append(")");
			System.out.println("\t"+code.toString());
		}
		
		Map<String,Value> val_map = new HashMap<String,Value>();
		val_map.put("P.HLR", hlr_set);
		val_map.put("P.scope.LLR", llr_set);
		val_map.put("P.scope.scope", trace_map);
		
		LogicValueMapper mapper = new LogicValueMapper(P,val_map);
		Boolean assign_res = mapper.assign();
		
		System.out.println("\n\nAssignment success? "+assign_res);
		
		
		ComputableAnalyzer analyzer = new ComputableAnalyzer("assign3");
		analyzer.setAnalyzed(P);
		Boolean computable = analyzer.computable();
		System.out.println("\nIs the P computable? "+computable);
		
		InferenceMachine im = new IMachine_Iterater("assign3_I");
		im.setFormulation(P);
		Boolean result = im.inference();
		
		System.out.println("Is the inference passed? "+result);
	}
	
	
	
	
	public static void analysis1(){
		LogicCreator creator = new LogicCreator("creator");
		
		LogicFormulation P = form1(creator);
		LogicPrinter printer = new LogicPrinter();
		
		System.out.println("Creating P: "+printer.printFormulation(P));
		
		BooleanObject TRUE = ValueCreator.getTrue();
		BooleanObject FALSE = ValueCreator.getFalse();
		
		Map<String,Value> map = new HashMap<String,Value>();
		
		map.put("P.A",TRUE);
		map.put("P._arg1", FALSE);
		map.put("P.C.D", FALSE);
		map.put("P._arg2.E", TRUE);
		map.put("P.C.F.G", FALSE);
		
		LogicValueMapper mapper = new LogicValueMapper(P,map);
		mapper.assign();
		
		ComputableAnalyzer analyzer = new ComputableAnalyzer("Analyzer Smith");
		Boolean res = analyzer.computable(P);
		System.out.println("Is that computable? "+res);
		
		IMachine_Iterater inferencer = new IMachine_Iterater("Dzt_Inferencer");
		inferencer.setFormulation(P);
		res = inferencer.inference();
		System.out.println("Result: "+res);
	}
	public static void analysis2(){
		
	}
	
	
}
