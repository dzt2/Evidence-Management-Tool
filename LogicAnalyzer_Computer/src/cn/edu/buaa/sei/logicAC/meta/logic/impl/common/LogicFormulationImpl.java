package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;

public abstract class LogicFormulationImpl implements LogicFormulation{
	Boolean result;
	
	@Override
	public void setResult(Object result) {
		if(result==null)this.result=null;
		if(result instanceof Boolean)this.result=(Boolean) result;
		else throw new ClassCastException("Invalid result set to the target Computable: LogicFormulation");
	}
	@Override
	public Boolean getResult() {return this.result;}
	@Override
	public void setResult(Boolean result) {this.result=result;}

}
