package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class CustodyImpl extends ManagedObjectImpl implements Custody, EvidenceProperty {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public CustodyImpl() {
		super(LMFContext.typeForName(Custody.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Custody.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Custody.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Custody.KEY_ID, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(Custody.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(Custody.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(Custody.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Custody.KEY_GID, value);
	}
	
	@Override
	public SafeRole getRole() {
		return (SafeRole) get(Custody.KEY_ROLE);
	}
	
	@Override
	public void setRole(SafeRole value) {
		set(Custody.KEY_ROLE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Custody.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(Custody.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(Custody.KEY_TYPE, value);
	}
	
}
