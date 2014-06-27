package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ProvenanceImpl extends ManagedObjectImpl implements Provenance, EvidenceProperty {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProvenanceImpl() {
		super(LMFContext.typeForName(Provenance.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Provenance.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Provenance.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Provenance.KEY_ID, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(Provenance.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(Provenance.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(Provenance.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Provenance.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Provenance.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(Provenance.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(Provenance.KEY_TYPE, value);
	}
	
}
