package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.op.Implication;

public class ImplicationImpl extends BinaryLogicOperatorImpl implements Implication{

	ImplicationImpl() throws Exception {super();}

	@Override
	public LogicFormulation getPrecondition() {return this.getLeft();}

	@Override
	public LogicFormulation getConclusion() {return this.getRight();}
	

}
