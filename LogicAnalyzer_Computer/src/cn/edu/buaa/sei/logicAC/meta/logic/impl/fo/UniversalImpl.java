package cn.edu.buaa.sei.logicAC.meta.logic.impl.fo;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.DiscourseDomain;
import cn.edu.buaa.sei.logicAC.meta.logic.fo.Universal;

public class UniversalImpl extends QuantifierOperatorImpl implements Universal{

	UniversalImpl(DiscourseDomain domain, LogicFormulation scope)
			throws Exception {
		super(domain, scope);
	}
}
