package cn.edu.buaa.sei.SVI.manage;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;

public interface IStructAssigner {
public boolean assign(Struct base,String path,Object val);
	
	public static final int FIRST_ONE = 0;
	public static final int ALL_VARS = -1;
	
	public boolean assignByName(Struct base,String name,Object val,int seq);
	
	public Variable getVariableByName(Struct base,String name,int seq);
	
	public Variable getVariable(Struct base,String path) throws Exception;
	
	public boolean confirmAssign(Variable variable,Object val);
	
	public IStructSearcher getSearcher();
}
