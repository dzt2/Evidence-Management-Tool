package cn.edu.buaa.sei.emt.logic;

public interface Quantification extends LogicFormulation {
	
	public static final String TYPE_NAME = "logicformulation.Quantification";
	public static final String KEY_SCOPE = "scope";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_VARIABLE = "variable";
	public static final String KEY_DOMAIN = "domain";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public LogicFormulation getScope();
	
	public void setScope(LogicFormulation value);
	
	public SetVariable getDomain();
	
	public void setDomain(SetVariable value);
	
	public Variable getVariable();
	
	public void setVariable(Variable value);
	
}
