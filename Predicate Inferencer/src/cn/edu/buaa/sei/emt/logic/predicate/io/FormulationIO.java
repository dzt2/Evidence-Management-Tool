package cn.edu.buaa.sei.emt.logic.predicate.io;

import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;

public interface FormulationIO {
	public Boolean selectDB(String name);
	public Boolean createDB(String name);
	public Boolean removeDB(String name);
	
	public Boolean IOReady();
	
	public Set<String> getFormulationNames();
	public LogicFormulation get(String name);
	public Boolean remove(String name);
	public Boolean set(String name,LogicFormulation form);
}
