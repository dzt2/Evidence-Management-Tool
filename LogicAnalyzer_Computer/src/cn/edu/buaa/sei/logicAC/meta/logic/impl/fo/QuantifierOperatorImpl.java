package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.QuantifierOperator;

public abstract class QuantifierOperatorImpl implements QuantifierOperator{
	Computable[] operands=new Computable[2];
	
	QuantifierOperatorImpl(DiscourseDomain domain,LogicFormulation scope) throws Exception{
		super();
		this.setOperands(domain, scope);
	}

	@Override
	public void setOperands(Computable left, Computable right) throws Exception {
		if(left==null||right==null)
			throw new Exception("Null left|right is invalid");
		if(!(left instanceof DiscourseDomain))
			throw new Exception("Left should be DiscourseDomain");
		if(!(right instanceof LogicFormulation))
			throw new Exception("Right should be LogicFormulation");
		
		this.setOperands((DiscourseDomain)left,(LogicFormulation)right);
	}
	@Override
	public Computable getLeft() {return this.operands[0];}
	@Override
	public Computable getRight() {return this.operands[1];}

	@Override
	public int dimension() {return 2;}
	@Override
	public Computable[] getOperands() {return this.operands;}

	@Override
	public void setOperands(DiscourseDomain domain, LogicFormulation scope)
			throws Exception {
		if(domain==null||scope==null)
			throw new Exception("Null domain|scope is invalid");
		this.operands[0]=domain;
		this.operands[1]=scope;
	}
	@Override
	public DiscourseDomain getDomain() {return (DiscourseDomain) this.operands[0];}
	@Override
	public LogicFormulation getScope() {return (LogicFormulation) this.operands[1];}

}
