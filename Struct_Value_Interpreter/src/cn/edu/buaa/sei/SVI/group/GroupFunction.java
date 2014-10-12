package cn.edu.buaa.sei.SVI.group;

import cn.edu.buaa.sei.SVI.core.function.Function;

public interface GroupFunction extends CompositeGroupStruct,Function{
	public GroupFunctionTemplate getTemplate();
}
