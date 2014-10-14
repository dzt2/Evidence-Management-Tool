package cn.edu.buaa.sei.SVI.group.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.group.Complement;

public class ComplementImpl extends GroupOperatorImpl implements Complement{
	
	GroupStruct operand;

	ComplementImpl(GroupStruct operand,CompositeStruct container) throws Exception {
		super(container);
		
		if(operand==null)
			throw new Exception("Null Operand is invalid");
		this.operand=operand;
		this.container.addChildStruct(operand);
	}

	@Override
	public void setOperand(Struct operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		if(!(operand instanceof GroupStruct))
			throw new Exception("GroupStruct is required in operand");
		
		GroupStruct o = (GroupStruct) operand;
		this.setOperand(o);
	}
	@Override
	public void setOperand(GroupStruct operand) throws Exception {
		if(operand==null)
			throw new Exception("Null operand is invalid");
		
		this.container.removeChildStruct(this.operand);
		this.operand=operand;
		this.container.addChildStruct(this.operand);
	}

	@Override
	public int getDimension() {return 1;}
	@Override
	public GroupStruct getOperand() {return this.operand;}
}
