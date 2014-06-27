package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceRelationImpl extends ManagedObjectImpl implements EvidenceRelation, EvidenceElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceRelationImpl() {
		super(LMFContext.typeForName(EvidenceRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceRelation.KEY_ID, value);
	}
	
	@Override
	public Evidence getSource() {
		return (Evidence) get(EvidenceRelation.KEY_SOURCE);
	}
	
	@Override
	public void setSource(Evidence value) {
		set(EvidenceRelation.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceRelation.KEY_GID, value);
	}
	
	@Override
	public Evidence getTarget() {
		return (Evidence) get(EvidenceRelation.KEY_TARGET);
	}
	
	@Override
	public void setTarget(Evidence value) {
		set(EvidenceRelation.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(EvidenceRelation.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(EvidenceRelation.KEY_TYPE, value);
	}
	
}
