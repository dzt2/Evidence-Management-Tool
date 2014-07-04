package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PropositionVariableImpl extends ManagedObjectImpl implements PropositionVariable, AtomicLogicFormulation, ValueVariable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PropositionVariableImpl() {
		super(LMFContext.typeForName(PropositionVariable.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(PropositionVariable.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(PropositionVariable.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(PropositionVariable.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(PropositionVariable.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(PropositionVariable.KEY_STATEMENT, value);
	}
	
	@Override
	public String getName() {
		return get(PropositionVariable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(PropositionVariable.KEY_NAME, value);
	}
	
	@Override
	public EntityValue getValue() {
		return (EntityValue) get(PropositionVariable.KEY_VALUE);
	}
	
	@Override
	public void setValue(EntityValue value) {
		set(PropositionVariable.KEY_VALUE, value);
	}
	
	@Override
	public String getGid() {
		return get(PropositionVariable.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(PropositionVariable.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(PropositionVariable.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public EntityElement getBindTo() {
		return (EntityElement) get(PropositionVariable.KEY_BINDTO);
	}
	
	@Override
	public void setBindTo(EntityElement value) {
		set(PropositionVariable.KEY_BINDTO, value);
	}
	
}
