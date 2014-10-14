package cn.edu.buaa.sei.SVI.group.impl;

import cn.edu.buaa.sei.SVI.core.variable.impl.TypedVariableImpl;
import cn.edu.buaa.sei.SVI.group.Group;
import cn.edu.buaa.sei.SVI.group.GroupVariable;

public class GroupVariableImpl extends TypedVariableImpl implements GroupVariable{

	GroupVariableImpl(String name) throws Exception {
		super(name, Group.class);
	}

	@Override
	public void assign(Group val) throws Exception {
		this.val=val;
	}
	@Override
	public Group read() throws Exception {
		if(this.val==null)return null;
		else return (Group) this.val;
	}

}
