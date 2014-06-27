package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ClaimImpl extends ManagedObjectImpl implements Claim, Assertion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ClaimImpl() {
		super(LMFContext.typeForName(Claim.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Claim.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Claim.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Claim.KEY_ID, value);
	}
	
	@Override
	public String getDescription() {
		return get(Claim.KEY_DESCRIPTION).stringValue();
	}
	
	@Override
	public void setDescription(String value) {
		set(Claim.KEY_DESCRIPTION, value);
	}
	
	@Override
	public String getName() {
		return get(Claim.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Claim.KEY_NAME, value);
	}
	
	@Override
	public boolean getSupported() {
		return get(Claim.KEY_SUPPORTED).boolValue();
	}
	
	@Override
	public void setSupported(boolean value) {
		set(Claim.KEY_SUPPORTED, value);
	}
	
	@Override
	public String getGid() {
		return get(Claim.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Claim.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Claim.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public boolean getAssured() {
		return get(Claim.KEY_ASSURED).boolValue();
	}
	
	@Override
	public void setAssured(boolean value) {
		set(Claim.KEY_ASSURED, value);
	}
	
}
