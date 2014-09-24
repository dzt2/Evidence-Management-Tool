package cn.edu.buaa.sei.logicAC.meta.logic.common;

import cn.edu.buaa.sei.logicAC.meta.common.var.base.BooleanVariable;

/**
 * LogicVariable is a LogicFormulation so to be computed in logic computation.<br>
 * LogicVariable is a BooleanVariable so to point to boolean value.<br>
 * LogicVariable is a AtomicLogicFormulation so not to be divided.
 * */
public interface LogicVariable extends BooleanVariable,AtomicLogicFormulation{
}
