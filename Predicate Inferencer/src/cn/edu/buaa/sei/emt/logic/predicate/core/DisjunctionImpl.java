package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.List;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class DisjunctionImpl extends ManagedObjectImpl implements Disjunction, LogicOperator {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public DisjunctionImpl() {
		super(LMFContext.typeForName(Disjunction.TYPE_NAME));
	}
	
	@Override
	public List<LogicFormulation> getFormulations() {
		return get(Disjunction.KEY_FORMULATIONS).listContent().toGenericList(LogicFormulation.class);
	}
	
}
