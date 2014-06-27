package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AtMostOneQuantificationImpl extends ManagedObjectImpl implements AtMostOneQuantification, AtMostQuantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AtMostOneQuantificationImpl() {
		super(LMFContext.typeForName(AtMostOneQuantification.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(AtMostOneQuantification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(AtMostOneQuantification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(AtMostOneQuantification.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(AtMostOneQuantification.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(AtMostOneQuantification.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getScope() {
		return (LogicFormulation) get(AtMostOneQuantification.KEY_SCOPE);
	}
	
	@Override
	public void setScope(LogicFormulation value) {
		set(AtMostOneQuantification.KEY_SCOPE, value);
	}
	
	@Override
	public String getName() {
		return get(AtMostOneQuantification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(AtMostOneQuantification.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(AtMostOneQuantification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(AtMostOneQuantification.KEY_GID, value);
	}
	
	@Override
	public SetVariable getDomain() {
		return (SetVariable) get(AtMostOneQuantification.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(SetVariable value) {
		set(AtMostOneQuantification.KEY_DOMAIN, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(AtMostOneQuantification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Variable getVariable() {
		return (Variable) get(AtMostOneQuantification.KEY_VARIABLE);
	}
	
	@Override
	public void setVariable(Variable value) {
		set(AtMostOneQuantification.KEY_VARIABLE, value);
	}
	
	@Override
	public int getUpper_bound() {
		return get(AtMostOneQuantification.KEY_UPPER_BOUND).intValue();
	}
	
	@Override
	public void setUpper_bound(int value) {
		set(AtMostOneQuantification.KEY_UPPER_BOUND, value);
	}
	
}
