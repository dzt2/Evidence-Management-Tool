package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;

public interface LRelationSet extends Value {
	
	public static final String TYPE_NAME = "value.LRelationSet";
	public static final String KEY_RELATIONS = "relations";
	
	
	public List<LRelation> getRelations();
	
}
