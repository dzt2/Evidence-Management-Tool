package cn.edu.buaa.sei.emt.logic;
import java.util.List;

public interface PredicateFormulation extends LogicFormulation, RelationVariable {
	
	public static final String TYPE_NAME = "logicformulation.PredicateFormulation";
	public static final String KEY_RELATION = "relation";
	public static final String KEY_ARGUMENTS = "arguments";
	public static final String KEY_BINDTO = "bindTo";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<Variable> getArguments();
	
}
