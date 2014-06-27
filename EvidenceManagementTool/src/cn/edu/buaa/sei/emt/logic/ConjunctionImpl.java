package cn.edu.buaa.sei.emt.logic;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ConjunctionImpl extends ManagedObjectImpl implements Conjunction, ArbitaryLogicOperation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ConjunctionImpl() {
		super(LMFContext.typeForName(Conjunction.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Conjunction.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Conjunction.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Conjunction.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(Conjunction.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(Conjunction.KEY_STATEMENT, value);
	}
	
	@Override
	public String getName() {
		return get(Conjunction.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Conjunction.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Conjunction.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Conjunction.KEY_GID, value);
	}
	
	@Override
	public List<LogicFormulation> getOperators() {
		return get(Conjunction.KEY_OPERATORS).listContent().toGenericList(LogicFormulation.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Conjunction.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
