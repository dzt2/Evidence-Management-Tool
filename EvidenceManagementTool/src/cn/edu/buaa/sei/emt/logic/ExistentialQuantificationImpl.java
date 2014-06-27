package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ExistentialQuantificationImpl extends ManagedObjectImpl implements ExistentialQuantification, AtLeastQuantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ExistentialQuantificationImpl() {
		super(LMFContext.typeForName(ExistentialQuantification.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ExistentialQuantification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ExistentialQuantification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ExistentialQuantification.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(ExistentialQuantification.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(ExistentialQuantification.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getScope() {
		return (LogicFormulation) get(ExistentialQuantification.KEY_SCOPE);
	}
	
	@Override
	public void setScope(LogicFormulation value) {
		set(ExistentialQuantification.KEY_SCOPE, value);
	}
	
	@Override
	public int getLower_bound() {
		return get(ExistentialQuantification.KEY_LOWER_BOUND).intValue();
	}
	
	@Override
	public void setLower_bound(int value) {
		set(ExistentialQuantification.KEY_LOWER_BOUND, value);
	}
	
	@Override
	public String getName() {
		return get(ExistentialQuantification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ExistentialQuantification.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ExistentialQuantification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ExistentialQuantification.KEY_GID, value);
	}
	
	@Override
	public SetVariable getDomain() {
		return (SetVariable) get(ExistentialQuantification.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(SetVariable value) {
		set(ExistentialQuantification.KEY_DOMAIN, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ExistentialQuantification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Variable getVariable() {
		return (Variable) get(ExistentialQuantification.KEY_VARIABLE);
	}
	
	@Override
	public void setVariable(Variable value) {
		set(ExistentialQuantification.KEY_VARIABLE, value);
	}
	
}
