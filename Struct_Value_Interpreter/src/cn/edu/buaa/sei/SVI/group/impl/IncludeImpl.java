package cn.edu.buaa.sei.SVI.group.impl;

import cn.edu.buaa.sei.SVI.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.core.Struct;
import cn.edu.buaa.sei.SVI.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.group.Include;
import cn.edu.buaa.sei.SVI.logic.impl.LogicOperatorImpl;

public class IncludeImpl extends LogicOperatorImpl implements Include{

	Struct left;
	GroupStruct right;
	
	protected IncludeImpl(Struct left,GroupStruct right,CompositeStruct container) throws Exception {
		super(container);
		if(left==null||right==null)
			throw new Exception("Null Operands are invalid");
		
		this.left=left; this.right=right;
		this.container.addChildStruct(this.left);
		this.container.addChildStruct(this.right);
	}

	@Override
	public void setOperands(Struct left, Struct right) throws Exception {
		if(left==null||right==null)
			throw new Exception("Null Operands are invalid");
		if(!(right instanceof GroupStruct))
			throw new Exception("GroupStruct is required for right");
		
		GroupStruct t = (GroupStruct) right;
		
		this.setOperands(left, t);
	}
	@Override
	public void setOperands(Struct left, GroupStruct right) throws Exception {
		if(left==null||right==null)
			throw new Exception("Null Operands are invalid");
		
		this.container.removeChildStruct(this.right);
		this.container.removeChildStruct(this.left);
		
		this.left=left; this.right = right;
		
		this.container.addChildStruct(this.left);
		this.container.addChildStruct(this.right);
	}
	
	@Override
	public int getDimension() {return 2;}

	@Override
	public Struct getLeftOperand() {return this.left;}
	@Override
	public GroupStruct getRightOperand() {return this.right;}

	

}
