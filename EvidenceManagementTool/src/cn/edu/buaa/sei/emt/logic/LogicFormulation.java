package cn.edu.buaa.sei.emt.logic;

public interface LogicFormulation extends LogicElement {
	
	public static final String TYPE_NAME = "logicformulation.LogicFormulation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Statement getStatement();
	
	public void setStatement(Statement value);
	
	public String getName();
	
	public void setName(String value);
	
}
