package cn.edu.buaa.sei.SVI.manage;

import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;

public interface IStructSearcher {
	public boolean confirmPath(Struct base,String path);
	
	public Struct get(Struct base,String path) throws Exception;
	
	public Set<Variable> getVariablesUnderBase(Struct base) throws Exception;
	
	public boolean contain(Struct base,Struct child);
	
	public Struct[] generatePath(Struct src,Struct trg) throws Exception;
	
	public Set<Variable> getVariablesByName(Struct base,String name) throws Exception;
	
	public Variable getFirstVariableByName(Struct base,String name) throws Exception;
	
	public Variable getVariableByName(Struct base,String name,int seq) throws Exception;
	
	public Variable[] getVariableListByName(Struct base,String name) throws Exception;
	
	public Map<String,Variable> getVariableMap(Struct base) throws Exception;
}
