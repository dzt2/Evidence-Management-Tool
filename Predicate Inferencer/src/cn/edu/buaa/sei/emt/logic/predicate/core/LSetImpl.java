package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class LSetImpl extends ManagedObjectImpl implements LSet, Value {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public LSetImpl() {
		super(LMFContext.typeForName(LSet.TYPE_NAME));
	}
	
	@Override
	public List<LObject> getValues() {
		return get(LSet.KEY_VALUES).listContent().toGenericList(LObject.class);
	}
	
}
