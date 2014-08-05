package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class LRelationSetImpl extends ManagedObjectImpl implements LRelationSet, Value {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public LRelationSetImpl() {
		super(LMFContext.typeForName(LRelationSet.TYPE_NAME));
	}
	
	@Override
	public List<LRelation> getRelations() {
		return get(LRelationSet.KEY_RELATIONS).listContent().toGenericList(LRelation.class);
	}
	
}
