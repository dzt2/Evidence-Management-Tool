package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface LogicFormulation extends ManagedObject {
	
	public static final String TYPE_NAME = "logic_form.LogicFormulation";
	public static final String KEY_ARGUMENTS = "arguments";
	public static final String KEY_NAME = "name";
	
	
	public List<Variable> getArguments();
	
	public String getName();
	
	public void setName(String value);
	
}
