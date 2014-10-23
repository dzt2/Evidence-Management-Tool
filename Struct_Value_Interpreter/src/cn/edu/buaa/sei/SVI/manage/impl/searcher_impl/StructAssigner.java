package cn.edu.buaa.sei.SVI.manage.impl.searcher_impl;

import java.util.Set;

import cn.edu.buaa.sei.SVI.manage.IStructAssigner;
import cn.edu.buaa.sei.SVI.manage.IStructSearcher;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;

public class StructAssigner implements IStructAssigner{
	IStructSearcher searcher;
	
	public StructAssigner(IStructSearcher searcher) throws Exception{
		if(searcher==null)throw new Exception("Null searcher is invalid");
		this.searcher = searcher;
	}

	@Override
	public boolean assign(Struct base, String path, Object val) {
		if(base==null||path==null)return false;
		
		Variable var=null;
		try {
			var = (Variable) this.searcher.get(base, path);
		} catch (Exception e) {
			System.err.println("Invalid Path: "+path);
			return false;
		}
		
		if(var!=null){
			try {
				var.assign(val);
				return true;
			} catch (Exception e) {
				System.err.println("Type match failed.");
			}
		}
		
		System.err.println("Invalid path --> not variable");
		return false;
	}

	@Override
	public boolean assignByName(Struct base, String name, Object val, int seq) {
		if(base==null||name==null)return false;
		
		if(seq==ALL_VARS){
			try {
				Set<Variable> vars = this.searcher.getVariablesByName(base, name);
				boolean flag = true;
				for(Variable var:vars){
					try{
						var.assign(val);
					}catch(Exception ex){
						System.err.println("Assignment failed at: "+var.getClass().getCanonicalName()+"@{"+var.hashCode()+"}");
						flag=false;
						continue;
					}
				}
				return flag;
			} catch (Exception e) {
				System.err.println("Search failed");
				return false;
			}
		}
		else{
			try {
				Variable var = this.searcher.getVariableByName(base, name, seq);
				try{
					var.assign(val);
					return true;
				}catch(Exception ex){
					System.err.println("Assignment failed at: "+var.getClass().getCanonicalName()+"@{"+var.hashCode()+"}");
					return false;
				}
			} catch (Exception e) {
				System.err.println("Search failed");
				return false;
			}
		}
	}

	@Override
	public Variable getVariableByName(Struct base, String name, int seq) {
		try {
			return this.searcher.getVariableByName(base, name, seq);
		} catch (Exception e) {
			System.err.println("Search failed");
			return null;
		}
	}

	@Override
	public Variable getVariable(Struct base, String path) throws Exception {
		return (Variable) this.searcher.get(base, path);
	}

	@Override
	public boolean confirmAssign(Variable variable, Object val) {
		if(variable==null)return false;
		
		boolean flag = true;
		Object ov = null;
		try {
			ov = variable.read();
			variable.assign(val);
			variable.assign(ov);
		} catch (Exception e) {
			flag = false;
			
		}
		
		try {
			variable.assign(ov);
		} catch (Exception e) {
			return false;
		}
		return flag;
	}

	@Override
	public IStructSearcher getSearcher() {
		return this.searcher;
	}
	
}
