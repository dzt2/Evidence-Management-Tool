package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface PredicateFormulation extends AtomFormulation, Bindable {
	
	public static final String TYPE_NAME = "variable.PredicateFormulation";
	public static final String KEY_NAME = "name";
	public static final String KEY_ASSOCIATED_RELATIONS = "associated_relations";
	public static final String KEY_VALUE = "value";
	public static final String KEY_VARIABLES = "variables";
	
	
	public LRelationSet getAssociated_relations();
	
	public void setAssociated_relations(LRelationSet value);
	
	public List<Variable> getVariables();
	
}
