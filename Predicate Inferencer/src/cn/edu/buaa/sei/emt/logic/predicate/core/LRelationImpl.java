package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class LRelationImpl extends ManagedObjectImpl implements LRelation, Value {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public LRelationImpl() {
		super(LMFContext.typeForName(LRelation.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(LRelation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(LRelation.KEY_NAME, value);
	}
	
	@Override
	public List<LObject> getElements() {
		return get(LRelation.KEY_ELEMENTS).listContent().toGenericList(LObject.class);
	}
	
}
