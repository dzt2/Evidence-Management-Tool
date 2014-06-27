package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class NegationImpl extends ManagedObjectImpl implements Negation, UnaryLogicOperation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public NegationImpl() {
		super(LMFContext.typeForName(Negation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Negation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Negation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Negation.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(Negation.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(Negation.KEY_STATEMENT, value);
	}
	
	@Override
	public String getName() {
		return get(Negation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Negation.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Negation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Negation.KEY_GID, value);
	}
	
	@Override
	public LogicFormulation getFormulation() {
		return (LogicFormulation) get(Negation.KEY_FORMULATION);
	}
	
	@Override
	public void setFormulation(LogicFormulation value) {
		set(Negation.KEY_FORMULATION, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Negation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
