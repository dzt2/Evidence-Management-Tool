package cn.edu.buaa.sei.logicAC.meta.common.impl.function;

import cn.edu.buaa.sei.logicAC.meta.common.function.Function;
import cn.edu.buaa.sei.logicAC.meta.common.function.FunctionTemplate;

public abstract class FunctionImpl implements Function{
	Object result;
	FunctionTemplate template;
	
	protected FunctionImpl(FunctionTemplate template) throws Exception{
		if(template==null)
			throw new Exception("Null template cannot be used in defining a function");
		this.template=template;
	}
	
	@Override
	public Object getResult() {return this.result;}

	@Override
	public void setResult(Object result) {this.result=result;}

	@Override
	public FunctionTemplate getTemplate() {return this.template;}

}
