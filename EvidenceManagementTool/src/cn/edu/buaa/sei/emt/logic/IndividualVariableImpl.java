package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class IndividualVariableImpl extends ManagedObjectImpl implements IndividualVariable, Variable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public IndividualVariableImpl() {
		super(LMFContext.typeForName(IndividualVariable.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(IndividualVariable.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(IndividualVariable.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(IndividualVariable.KEY_ID, value);
	}
	
	@Override
	public EntityIndividual getIndividual() {
		return (EntityIndividual) get(IndividualVariable.KEY_INDIVIDUAL);
	}
	
	@Override
	public void setIndividual(EntityIndividual value) {
		set(IndividualVariable.KEY_INDIVIDUAL, value);
	}
	
	@Override
	public String getName() {
		return get(IndividualVariable.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(IndividualVariable.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(IndividualVariable.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(IndividualVariable.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(IndividualVariable.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public EntityElement getBindTo() {
		return (EntityElement) get(IndividualVariable.KEY_BINDTO);
	}
	
	@Override
	public void setBindTo(EntityElement value) {
		set(IndividualVariable.KEY_BINDTO, value);
	}
	
}
