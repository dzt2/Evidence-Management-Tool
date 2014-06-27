package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class TimeImpl extends ManagedObjectImpl implements Time, EvidenceProperty {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public TimeImpl() {
		super(LMFContext.typeForName(Time.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Time.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Time.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Time.KEY_ID, value);
	}
	
	@Override
	public String getStart() {
		return get(Time.KEY_START).stringValue();
	}
	
	@Override
	public void setStart(String value) {
		set(Time.KEY_START, value);
	}
	
	@Override
	public Evidence getEvidence() {
		return (Evidence) get(Time.KEY_EVIDENCE);
	}
	
	@Override
	public void setEvidence(Evidence value) {
		set(Time.KEY_EVIDENCE, value);
	}
	
	@Override
	public String getGid() {
		return get(Time.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Time.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Time.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public String getEnd() {
		return get(Time.KEY_END).stringValue();
	}
	
	@Override
	public void setEnd(String value) {
		set(Time.KEY_END, value);
	}
	
}
