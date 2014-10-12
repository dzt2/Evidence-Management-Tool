package cn.edu.buaa.sei.SVI.group;

import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.logic.LogicFunction;

/**
 * ConditionGroup is the group whose elements satisfy some condition {Logic Function}<br>
 * Which formation is: {x|P(x)}, where P(x) is <b>condition</b>, and x is <b>variable</b>
 * */
public interface ConditionGroup extends Group{
	/**
	 * Return the condition
	 * */
	public LogicFunction getCondition();
	/**
	 * Return the variable in the condition function.
	 * */
	public Variable getVariable();
}
