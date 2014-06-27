package cn.edu.buaa.sei.emt.logic;

public interface UnaryLogicOperation extends LogicOperation {
	
	public static final String TYPE_NAME = "logicformulation.UnaryLogicOperation";
	public static final String KEY_FORMULATION = "formulation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public LogicFormulation getFormulation();
	
	public void setFormulation(LogicFormulation value);
	
}
