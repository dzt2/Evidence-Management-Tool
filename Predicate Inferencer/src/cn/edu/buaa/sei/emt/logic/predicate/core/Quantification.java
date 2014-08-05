package cn.edu.buaa.sei.emt.logic.predicate.core;

public interface Quantification extends LogicFormulation {
	
	public static final String TYPE_NAME = "logic_form.Quantification";
	public static final String KEY_SCOPE_FORMULATION = "scope_formulation";
	public static final String KEY_NAME = "name";
	public static final String KEY_DOMAIN = "domain";
	
	
	public LogicFormulation getScope_formulation();
	
	public void setScope_formulation(LogicFormulation value);
	
	public DiscourseDomain getDomain();
	
	public void setDomain(DiscourseDomain value);
	
}
