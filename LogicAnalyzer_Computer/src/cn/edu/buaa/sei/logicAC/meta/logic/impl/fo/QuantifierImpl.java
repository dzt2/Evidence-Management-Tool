package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.common.expr.Operator;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Quantifier;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.QuantifierOperator;
import cn.edu.buaa.sei.logicAC.meta.logic.impl.common.LogicFormulationImpl;

public class QuantifierImpl extends LogicFormulationImpl implements Quantifier{
	QuantifierOperator op;
	
	QuantifierImpl(QuantifierOperator op) throws Exception{
		super();
		if(op==null)
			throw new Exception("Null QuantifierOperator is invalid");
		this.op=op;
	}
	
	@Override
	public Operator getTemplate() {return this.op;}

	@Override
	public QuantifierOperator getOperator() {return this.op;}

}
