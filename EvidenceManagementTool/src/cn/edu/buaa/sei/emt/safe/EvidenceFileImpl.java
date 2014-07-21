package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceFileImpl extends ManagedObjectImpl implements EvidenceFile, Evidence {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceFileImpl() {
		super(LMFContext.typeForName(EvidenceFile.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceFile.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceFile.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceFile.KEY_ID, value);
	}
	
	@Override
	public List<EvidenceRef> getSupport_refs() {
		return get(EvidenceFile.KEY_SUPPORT_REFS).listContent().toGenericList(EvidenceRef.class);
	}
	
	@Override
	public String getName() {
		return get(EvidenceFile.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(EvidenceFile.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceFile.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceFile.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceFile.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public String getFile_url() {
		return get(EvidenceFile.KEY_FILE_URL).stringValue();
	}
	
	@Override
	public void setFile_url(String value) {
		set(EvidenceFile.KEY_FILE_URL, value);
	}
	
}
