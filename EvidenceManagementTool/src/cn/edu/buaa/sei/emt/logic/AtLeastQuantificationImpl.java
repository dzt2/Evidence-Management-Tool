package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AtLeastQuantificationImpl extends ManagedObjectImpl implements AtLeastQuantification, Quantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AtLeastQuantificationImpl() {
		super(LMFContext.typeForName(AtLeastQuantification.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(AtLeastQuantification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(AtLeastQuantification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(AtLeastQuantification.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(AtLeastQuantification.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(AtLeastQuantification.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getScope() {
		return (LogicFormulation) get(AtLeastQuantification.KEY_SCOPE);
	}
	
	@Override
	public void setScope(LogicFormulation value) {
		set(AtLeastQuantification.KEY_SCOPE, value);
	}
	
	@Override
	public int getLower_bound() {
		return get(AtLeastQuantification.KEY_LOWER_BOUND).intValue();
	}
	
	@Override
	public void setLower_bound(int value) {
		set(AtLeastQuantification.KEY_LOWER_BOUND, value);
	}
	
	@Override
	public String getName() {
		return get(AtLeastQuantification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(AtLeastQuantification.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(AtLeastQuantification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(AtLeastQuantification.KEY_GID, value);
	}
	
	@Override
	public SetVariable getDomain() {
		return (SetVariable) get(AtLeastQuantification.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(SetVariable value) {
		set(AtLeastQuantification.KEY_DOMAIN, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(AtLeastQuantification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Variable getVariable() {
		return (Variable) get(AtLeastQuantification.KEY_VARIABLE);
	}
	
	@Override
	public void setVariable(Variable value) {
		set(AtLeastQuantification.KEY_VARIABLE, value);
	}
	
}
