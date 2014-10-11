package cn.edu.buaa.sei.SVI.logic;

import cn.edu.buaa.sei.SVI.core.expression.Expression;
import cn.edu.buaa.sei.SVI.core.expression.Operator;

public class Test {
	public void testLogicExpression(LogicExpression expr){
		Expression e = expr;
		Operator op = e.getOperator();
		System.out.println(op);
	}
}
