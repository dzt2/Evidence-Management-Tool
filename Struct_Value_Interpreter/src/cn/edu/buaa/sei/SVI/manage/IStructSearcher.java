package cn.edu.buaa.sei.SVI.manage;

import java.util.Set;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;

public interface IStructSearcher {
	public Struct get(Struct base,String path) throws Exception;
	
	public Set<Variable> getVariablesUnderBase(Struct base) throws Exception;
	
	public boolean contain(Struct base,Struct child);
	
	public Struct[] generatePath(Struct src,Struct trg) throws Exception;
}
