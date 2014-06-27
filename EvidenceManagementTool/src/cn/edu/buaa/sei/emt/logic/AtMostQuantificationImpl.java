package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AtMostQuantificationImpl extends ManagedObjectImpl implements AtMostQuantification, Quantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AtMostQuantificationImpl() {
		super(LMFContext.typeForName(AtMostQuantification.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(AtMostQuantification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(AtMostQuantification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(AtMostQuantification.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(AtMostQuantification.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(AtMostQuantification.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getScope() {
		return (LogicFormulation) get(AtMostQuantification.KEY_SCOPE);
	}
	
	@Override
	public void setScope(LogicFormulation value) {
		set(AtMostQuantification.KEY_SCOPE, value);
	}
	
	@Override
	public String getName() {
		return get(AtMostQuantification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(AtMostQuantification.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(AtMostQuantification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(AtMostQuantification.KEY_GID, value);
	}
	
	@Override
	public SetVariable getDomain() {
		return (SetVariable) get(AtMostQuantification.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(SetVariable value) {
		set(AtMostQuantification.KEY_DOMAIN, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(AtMostQuantification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Variable getVariable() {
		return (Variable) get(AtMostQuantification.KEY_VARIABLE);
	}
	
	@Override
	public void setVariable(Variable value) {
		set(AtMostQuantification.KEY_VARIABLE, value);
	}
	
	@Override
	public int getUpper_bound() {
		return get(AtMostQuantification.KEY_UPPER_BOUND).intValue();
	}
	
	@Override
	public void setUpper_bound(int value) {
		set(AtMostQuantification.KEY_UPPER_BOUND, value);
	}
	
}
