package cn.edu.buaa.sei.logicAC.meta.logic.impl.computer;

import java.util.HashSet;
import java.util.Set;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.AtomicLogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicExpression;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunction;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFunctionTemplate;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicVariable;
import cn.edu.buaa.sei.logicAC.meta.logic.computer.LogicComputerUnit;
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
import cn.edu.buaa.sei.logicAC.meta.logic.op.Conjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Disjunction;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Equivalence;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Implication;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Negation;

public class LogicComputerUnit_R implements LogicComputerUnit{
	Set<LogicFormulation> records = new HashSet<LogicFormulation>();
	
	LogicComputerUnit_R(){records.clear();}

	@Override
	public Compute_State compute(LogicFormulation x) {
		this.records.clear();
		this.clearLogicFormulation(x);
		this.records.clear();
		return this.computeLogicFormulation(x);
	}
	
	void clearLogicFormulation(LogicFormulation x){
		if(x==null||this.records.contains(x))return;
		
		this.records.add(x);
		
		if(x instanceof AtomicLogicFormulation){return;}
		else if(x instanceof LogicExpression){
			x.setResult(null);
			LogicOperator op = ((LogicExpression) x).getOperator();
			
			if(op==null);
			if(op instanceof Conjunction||op instanceof Disjunction){
				LogicFormulation[] operands = op.getOperands();
				for(int i=0;i<operands.length;i++)
					this.clearLogicFormulation(operands[i]);
			}
			else if(op instanceof Negation)this.clearLogicFormulation(((Negation) op).getOperand());
			else if(op instanceof Implication){
				this.clearLogicFormulation(((Implication) op).getPrecondition());
				this.clearLogicFormulation(((Implication) op).getConclusion());
			}
			else if(op instanceof Equivalence){
				this.clearLogicFormulation(((Equivalence) op).getLeft());
				this.clearLogicFormulation(((Equivalence) op).getRight());
			}
			else if(op instanceof QuantifierOperator){
				this.clearLogicFormulation(((QuantifierOperator) op).getScope());
			}
		}
		else if(x instanceof LogicFunction){
			x.setResult(null);
		}
		
	}
	
	Compute_State computeLogicFormulation(LogicFormulation x){
		if(x==null)return Compute_State.UNKNOWN;
		else if(this.records.contains(x))return Compute_State.CIRCLE;
		
		this.records.add(x);
		
		if(x instanceof AtomicLogicFormulation){
			if(x instanceof LogicVariable)return this.computeLogicVariable((LogicVariable) x);
			else return Compute_State.UNKNOWN;
		}
		else if(x instanceof LogicExpression){
			LogicOperator op = ((LogicExpression) x).getOperator();
			
			if(op==null)return Compute_State.UNKNOWN;
			if(op instanceof Conjunction)return this.computeConjunction((LogicExpression) x);
			else if(op instanceof Disjunction)return this.computeDisjunction((LogicExpression) x);
			else if(op instanceof Negation)return this.computeNegation((LogicExpression) x);
			else if(op instanceof Implication)return this.computeImplication((LogicExpression) x);
			else if(op instanceof Equivalence)return this.computeEquivalence((LogicExpression) x);
			else return Compute_State.UNKNOWN;
		}
		else if(x instanceof Quantifier){
			QuantifierOperator op = ((Quantifier) x).getOperator();
			if(op instanceof Universal){return this.computeUniversal((Quantifier) x);}
			else if(op instanceof Existential){return this.computeExistential((Quantifier) x);}
			else if(op instanceof AtLeastQuantifier){return this.computeAtLeast((Quantifier) x);}
			else if(op instanceof AtMostQuantifier){return this.computeAtMost((Quantifier) x);}
			else if(op instanceof RangeQuantifier){return this.computeRange((Quantifier) x);}
			else return Compute_State.UNKNOWN;
		}
		else if(x instanceof LogicFunction){
			if(x instanceof PredicateFunction){return this.computePredicate((PredicateFunction) x);}
			else return Compute_State.UNKNOWN;
		}
		return Compute_State.UNKNOWN;
	}
	Compute_State computeLogicVariable(LogicVariable x){
		if(x==null)return Compute_State.UNKNOWN;
		else if(x.getResult()==null)return Compute_State.NOT_READY;
		else return Compute_State.COMPUTABLE;
	}
	Compute_State computeNegation(LogicExpression x){
		if(x==null)return Compute_State.UNKNOWN;
		
		Negation op = (Negation) x.getOperator();
		LogicFormulation child = op.getOperand();
		if(child==null)return Compute_State.UNKNOWN;
		
		Compute_State state=Compute_State.NOT_READY;
		if(child.getResult()==null)state=this.computeLogicFormulation(child);
		
		if(child.getResult()==null)return state;
		else{
			x.setResult(!child.getResult());
			return Compute_State.COMPUTABLE;
		}
	}
	Compute_State computeImplication(LogicExpression x){
		if(x==null)return Compute_State.UNKNOWN;
		
		Implication op = (Implication) x.getOperator();
		LogicFormulation precondition = op.getPrecondition();
		LogicFormulation conclusion = op.getConclusion();
		
		if(precondition==null||conclusion==null)return Compute_State.UNKNOWN;
		
		Compute_State state = Compute_State.NOT_READY;
		if(precondition.getResult()==null)state=this.computeLogicFormulation(precondition);
		if(precondition.getResult()==null)return state;
		else if(precondition.getResult()==false){
			x.setResult(true);
			return Compute_State.COMPUTABLE;
		}
		else{
			state = Compute_State.NOT_READY;
			if(conclusion.getResult()==null)state=this.computeLogicFormulation(conclusion);
			if(conclusion.getResult()==null)return state;
			else{
				x.setResult(conclusion.getResult());
				return Compute_State.COMPUTABLE;
			}
		}
	}
	Compute_State computeEquivalence(LogicExpression x){
		if(x==null)return Compute_State.UNKNOWN;
		
		Equivalence op = (Equivalence) x.getOperator();
		LogicFormulation f1 = op.getLeft();
		LogicFormulation f2 = op.getRight();
		
		if(f1==null||f2==null)return Compute_State.UNKNOWN;
		
		Compute_State state = Compute_State.NOT_READY;
		if(f1.getResult()==null)state=this.computeLogicFormulation(f1);
		if(f1.getResult()==null)return state;
		
		state = Compute_State.NOT_READY;
		if(f2.getResult()==null)state=this.computeLogicFormulation(f2);
		if(f1.getResult()==null||f2.getResult()==null)return state;
		else{
			x.setResult(f1.getResult()==f2.getResult());
			return Compute_State.COMPUTABLE;
		}
	}
	Compute_State computeConjunction(LogicExpression x){
		if(x==null)return Compute_State.UNKNOWN;
		
		Conjunction op = (Conjunction) x.getOperator();
		LogicFormulation[] children = op.getOperands();
		
		if(children==null)return Compute_State.UNKNOWN;
		else{
			boolean containNull = false;
			for(int i=0;i<op.getCurrentSize();i++){
				LogicFormulation child = children[i];
				
				if(child==null)return Compute_State.UNKNOWN;
				
				if(child.getResult()==null)this.computeLogicFormulation(child);
				if(child.getResult()==null){
					containNull=true;continue;
				}
				else if(child.getResult()==false){
					x.setResult(false);
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(!containNull){
				x.setResult(true);
				return Compute_State.COMPUTABLE;
			}
			else return Compute_State.NOT_READY;
		}
	}
	Compute_State computeDisjunction(LogicExpression x){
		if(x==null)return Compute_State.UNKNOWN;
		
		Disjunction op = (Disjunction) x.getOperator();
		LogicFormulation[] children = op.getOperands();
		
		if(children==null)return Compute_State.UNKNOWN;
		else{
			boolean containNull = false;
			for(int i=0;i<op.getCurrentSize();i++){
				LogicFormulation child = children[i];
				if(child==null)return Compute_State.UNKNOWN;
				
				if(child.getResult()==null)this.computeLogicFormulation(child);
				if(child.getResult()==null){
					containNull=true;
				}
				else if(child.getResult()==true){
					x.setResult(true);
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(!containNull){
				x.setResult(false);
				return Compute_State.COMPUTABLE;
			}
			else return Compute_State.NOT_READY;
		}
	}

	Compute_State computeUniversal(Quantifier q){
		if(q==null)return Compute_State.UNKNOWN;
		
		Universal op = (Universal) q.getOperator();
		
		DiscourseDomain domain = op.getDomain();
		LogicFormulation scope = op.getScope();
		
		if(domain==null||scope==null)return Compute_State.UNKNOWN;
		
		try {
			Set<Object> values = domain.read();
			boolean containNull = false;
			for(Object val:values){
				domain.getIterator().assign(val);
				
				records.remove(scope);
				this.computeLogicFormulation(scope);
				if(scope.getResult()==null)containNull=true;
				else if(scope.getResult()==false){
					q.setResult(false);
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(!containNull){
				//System.out.println("INININ");
				q.setResult(true);
				return Compute_State.COMPUTABLE;
			}
			else return Compute_State.NOT_READY;
		} catch (Exception e) {
			return Compute_State.NOT_READY;
		}
		
	}
	Compute_State computeExistential(Quantifier q){
		
		if(q==null)return Compute_State.UNKNOWN;
		
		Existential op = (Existential) q.getOperator();
		
		DiscourseDomain domain = op.getDomain();
		LogicFormulation scope = op.getScope();
		
		if(domain==null||scope==null)return Compute_State.UNKNOWN;
		
		try {
			Set<Object> values = domain.read();
			boolean containNull = false;
			for(Object val:values){
				domain.getIterator().assign(val);
				
				records.remove(scope);
				this.computeLogicFormulation(scope);
				
				if(scope.getResult()==null)containNull=true;
				else if(scope.getResult()==true){
					q.setResult(true);
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(!containNull){
				q.setResult(false);
				return Compute_State.COMPUTABLE;
			}
			else return Compute_State.NOT_READY;
		} catch (Exception e) {
			return Compute_State.NOT_READY;
		}
	}
	Compute_State computeAtLeast(Quantifier x){
		if(x==null)return Compute_State.UNKNOWN;
		
		AtLeastQuantifier op = (AtLeastQuantifier) x.getOperator();
		DiscourseDomain domain = op.getDomain();
		LogicFormulation scope = op.getScope();
		
		if(domain==null||scope==null)return Compute_State.UNKNOWN;
		
		try {
			Set<?> values = domain.read();
			
			int count = 0;
			int null_count = 0;
			
			for(Object val:values){
				domain.getIterator().assign(val);
				
				records.remove(scope);
				this.computeLogicFormulation(scope);
				if(scope.getResult()==null)null_count++;
				else if(scope.getResult()==true){
					count++;
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(count>=op.getLowerBound()){
				x.setResult(true);
				return Compute_State.COMPUTABLE;
			}
			else{
				if(count+null_count>=op.getLowerBound())return Compute_State.NOT_READY;
				else{
					x.setResult(false);
					return Compute_State.COMPUTABLE;
				}
			}
			
		} catch (Exception e) {
			return Compute_State.NOT_READY;
		}
		
	}
	Compute_State computeAtMost(Quantifier x){
		if(x==null)return Compute_State.UNKNOWN;
		
		AtMostQuantifier op = (AtMostQuantifier) x.getOperator();
		DiscourseDomain domain = op.getDomain();
		LogicFormulation scope = op.getScope();
		
		if(domain==null||scope==null)return Compute_State.UNKNOWN;
		
		try {
			Set<?> values = domain.read();
			
			int count = 0;
			int null_count = 0;
			
			for(Object val:values){
				domain.getIterator().assign(val);
				
				records.remove(scope);
				this.computeLogicFormulation(scope);
				if(scope.getResult()==null)null_count++;
				else if(scope.getResult()==true){
					count++;
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(count+null_count<=op.getUpperBound()){
				x.setResult(true);
				return Compute_State.COMPUTABLE;
			}
			else{
				if(count<=op.getUpperBound())return Compute_State.NOT_READY;
				else{
					x.setResult(false);
					return Compute_State.COMPUTABLE;
				}
			}
			
		} catch (Exception e) {
			return Compute_State.NOT_READY;
		}
	}
	Compute_State computeRange(Quantifier x){
		if(x==null)return Compute_State.UNKNOWN;
		
		RangeQuantifier op = (RangeQuantifier) x.getOperator();
		DiscourseDomain domain = op.getDomain();
		LogicFormulation scope = op.getScope();
		
		if(domain==null||scope==null)return Compute_State.UNKNOWN;
		
		try {
			Set<?> values = domain.read();
			
			int count = 0;
			int null_count = 0;
			
			for(Object val:values){
				domain.getIterator().assign(val);
				
				records.remove(scope);
				this.computeLogicFormulation(scope);
				
				if(scope.getResult()==null)null_count++;
				else if(scope.getResult()==true){
					count++;
					return Compute_State.COMPUTABLE;
				}
			}
			
			if(count+null_count<=op.getUpperBound()&&count>=op.getLowerBound()){
				x.setResult(true);
				return Compute_State.COMPUTABLE;
			}
			else{
				if(count>op.getUpperBound()||count+null_count<op.getLowerBound()){
					x.setResult(false);
					return Compute_State.COMPUTABLE;
				}
				else{
					return Compute_State.NOT_READY;
				}
			}
		} catch (Exception e) {
			return Compute_State.NOT_READY;
		}
	}
	
	Compute_State computePredicate(PredicateFunction x){
		if(x==null)return Compute_State.UNKNOWN;
		
		PredicateFunctionEnvironment env = x.getEnvironment();
		LogicFunctionTemplate template = x.getTemplate();
		
		if(env==null||template==null)return Compute_State.UNKNOWN;
		
		Variable[] arguments = template.getArguments();
		if(arguments==null||arguments.length<=0)return Compute_State.UNKNOWN;
		RelationSetVariable var = env.getRelationSetVariable();
		if(var==null)return Compute_State.UNKNOWN;
		
		RelationSet set = null;
		try {
			set = var.read();
		} catch (Exception e1) {
			return Compute_State.NOT_READY;
		}
		
		if(set==null)return Compute_State.NOT_READY;
		
		Object[] values = new Object[arguments.length];
		for(int i=0;i<arguments.length;i++){
			try {
				values[i]=arguments[i].read();
			} catch (Exception e) {
				return Compute_State.NOT_READY;
			}
		}
		
		x.setResult(set.containRelation(values));
		return Compute_State.COMPUTABLE;
	}
}
