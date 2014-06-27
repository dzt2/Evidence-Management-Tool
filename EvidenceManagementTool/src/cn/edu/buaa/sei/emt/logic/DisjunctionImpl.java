package cn.edu.buaa.sei.emt.logic;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class DisjunctionImpl extends ManagedObjectImpl implements Disjunction, ArbitaryLogicOperation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public DisjunctionImpl() {
		super(LMFContext.typeForName(Disjunction.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Disjunction.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Disjunction.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Disjunction.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(Disjunction.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(Disjunction.KEY_STATEMENT, value);
	}
	
	@Override
	public String getName() {
		return get(Disjunction.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Disjunction.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Disjunction.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Disjunction.KEY_GID, value);
	}
	
	@Override
	public List<LogicFormulation> getOperators() {
		return get(Disjunction.KEY_OPERATORS).listContent().toGenericList(LogicFormulation.class);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Disjunction.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
