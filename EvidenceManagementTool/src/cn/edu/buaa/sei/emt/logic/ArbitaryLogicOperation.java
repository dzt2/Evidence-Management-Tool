package cn.edu.buaa.sei.emt.logic;
import java.util.List;

public interface ArbitaryLogicOperation extends LogicOperation {
	
	public static final String TYPE_NAME = "logicformulation.ArbitaryLogicOperation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_GID = "gid";
	public static final String KEY_OPERATORS = "operators";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<LogicFormulation> getOperators();
	
}
