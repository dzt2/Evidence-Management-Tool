package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Existential;

public class ExistentialImpl extends QuantifierOperatorImpl implements Existential{

	ExistentialImpl(DiscourseDomain domain, LogicFormulation scope)
			throws Exception {
		super(domain, scope);
	}
}
