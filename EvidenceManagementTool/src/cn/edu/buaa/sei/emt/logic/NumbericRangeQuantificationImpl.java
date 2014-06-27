package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class NumbericRangeQuantificationImpl extends ManagedObjectImpl implements NumbericRangeQuantification, Quantification {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public NumbericRangeQuantificationImpl() {
		super(LMFContext.typeForName(NumbericRangeQuantification.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(NumbericRangeQuantification.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(NumbericRangeQuantification.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(NumbericRangeQuantification.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(NumbericRangeQuantification.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(NumbericRangeQuantification.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getScope() {
		return (LogicFormulation) get(NumbericRangeQuantification.KEY_SCOPE);
	}
	
	@Override
	public void setScope(LogicFormulation value) {
		set(NumbericRangeQuantification.KEY_SCOPE, value);
	}
	
	@Override
	public int getLower_bound() {
		return get(NumbericRangeQuantification.KEY_LOWER_BOUND).intValue();
	}
	
	@Override
	public void setLower_bound(int value) {
		set(NumbericRangeQuantification.KEY_LOWER_BOUND, value);
	}
	
	@Override
	public String getName() {
		return get(NumbericRangeQuantification.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(NumbericRangeQuantification.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(NumbericRangeQuantification.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(NumbericRangeQuantification.KEY_GID, value);
	}
	
	@Override
	public SetVariable getDomain() {
		return (SetVariable) get(NumbericRangeQuantification.KEY_DOMAIN);
	}
	
	@Override
	public void setDomain(SetVariable value) {
		set(NumbericRangeQuantification.KEY_DOMAIN, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(NumbericRangeQuantification.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public Variable getVariable() {
		return (Variable) get(NumbericRangeQuantification.KEY_VARIABLE);
	}
	
	@Override
	public void setVariable(Variable value) {
		set(NumbericRangeQuantification.KEY_VARIABLE, value);
	}
	
	@Override
	public int getUpper_bound() {
		return get(NumbericRangeQuantification.KEY_UPPER_BOUND).intValue();
	}
	
	@Override
	public void setUpper_bound(int value) {
		set(NumbericRangeQuantification.KEY_UPPER_BOUND, value);
	}
	
}
