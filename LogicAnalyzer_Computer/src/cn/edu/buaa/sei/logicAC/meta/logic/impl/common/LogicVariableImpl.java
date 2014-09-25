package cn.edu.buaa.sei.logicAC.meta.logic.impl.common;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.base.BooleanVariableImpl;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicVariable;

public class LogicVariableImpl extends BooleanVariableImpl implements LogicVariable{

	protected LogicVariableImpl(String name) throws Exception {super(name);}

	@Override
	public void setResult(Boolean result) {
		try {
			this.assign(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean getResult(){
		try {
			return this.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
