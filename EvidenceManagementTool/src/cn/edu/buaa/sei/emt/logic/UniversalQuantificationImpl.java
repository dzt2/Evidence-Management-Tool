package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class UniversalQuantificationImpl extends ManagedObjectImpl implements UniversalQuantification, Quantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public UniversalQuantificationImpl() {
		super(LMFContext.typeForName(UniversalQuantification.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(UniversalQuantification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(UniversalQuantification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(UniversalQuantification.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(UniversalQuantification.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(UniversalQuantification.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getScope() {
		return (LogicFormulation) get(UniversalQuantification.KEY_SCOPE);
	}
	
	@Override
	public void setScope(LogicFormulation value) {
		set(UniversalQuantification.KEY_SCOPE, value);
	}
	
	@Override
	public String getName() {
		return get(UniversalQuantification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(UniversalQuantification.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(UniversalQuantification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(UniversalQuantification.KEY_GID, value);
	}
	
	@Override
	public SetVariable getDomain() {
		return (SetVariable) get(UniversalQuantification.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(SetVariable value) {
		set(UniversalQuantification.KEY_DOMAIN, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(UniversalQuantification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Variable getVariable() {
		return (Variable) get(UniversalQuantification.KEY_VARIABLE);
	}
	
	@Override
	public void setVariable(Variable value) {
		set(UniversalQuantification.KEY_VARIABLE, value);
	}
	
}
