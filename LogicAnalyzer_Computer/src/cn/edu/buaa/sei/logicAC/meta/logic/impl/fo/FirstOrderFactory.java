package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.impl.core.ArrayContext;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.AtLeastQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.AtMostQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Existential;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.PredicateFunctionEnvironment;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Quantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RangeQuantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSet;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.RelationSetVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Universal;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.common.CommonLogicFactory;

public class FirstOrderFactory extends CommonLogicFactory{
	public static DiscourseDomain createDiscourseDomain(String name) throws Exception{
		return new DiscourseDomainImpl(name);
	}
	
	public static Quantifier createUniversal(DiscourseDomain domain,LogicFormulation scope) throws Exception{
		Universal op = new UniversalImpl(domain,scope);
		return new QuantifierImpl(op);
	}
	public static Quantifier createExistential(DiscourseDomain domain,LogicFormulation scope) throws Exception{
		Existential op = new ExistentialImpl(domain,scope);
		return new QuantifierImpl(op);
	}
	public static Quantifier createAtLeastQuantifier(DiscourseDomain domain,LogicFormulation scope,int lower) throws Exception{
		AtLeastQuantifier op = new AtLeastQuantifierImpl(domain,scope,lower);
		return new QuantifierImpl(op);
	}
	public static Quantifier createAtMostQuantifier(DiscourseDomain domain,LogicFormulation scope,int upper) throws Exception{
		AtMostQuantifier op = new AtMostQuantifierImpl(domain,scope,upper);
		return new QuantifierImpl(op);
	}
	public static Quantifier createRangeQuantifier(DiscourseDomain domain,LogicFormulation scope,int lower,int upper) throws Exception{
		RangeQuantifier op = new RangeQuantifierImpl(domain,scope,lower,upper);
		return new QuantifierImpl(op);
	}
	
	public static PredicateFunction createPredicate(LogicFunctionTemplate template,PredicateFunctionEnvironment env) throws Exception{
		return new PredicateFunctionImpl(template,env);
	}
	public static PredicateFunctionEnvironment createPredicateEnvironment(RelationSet value) throws Exception{
		PredicateFunctionEnvironment env = new PredicateFunctionEnvironmentImpl(new ArrayContext(),null);
		RelationSetVariable var = (RelationSetVariable) env.getVariable(PredicateFunctionEnvironment.RELATION);
		if(value!=null)var.assign(value);
		return env;
	}
	public static RelationSet createRelationSet(){return new RelationSetImpl();}
	
	
}
