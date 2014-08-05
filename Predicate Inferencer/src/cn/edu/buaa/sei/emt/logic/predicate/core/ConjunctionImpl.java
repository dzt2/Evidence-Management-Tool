package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ConjunctionImpl extends ManagedObjectImpl implements Conjunction, LogicOperator {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ConjunctionImpl() {
		super(LMFContext.typeForName(Conjunction.TYPE_NAME));
	}
	
	@Override
	public List<LogicFormulation> getFormulations() {
		return get(Conjunction.KEY_FORMULATIONS).listContent().toGenericList(LogicFormulation.class);
	}
	
}
