package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class ProcessRecordImpl extends ManagedObjectImpl implements ProcessRecord, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProcessRecordImpl() {
		super(LMFContext.typeForName(ProcessRecord.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ProcessRecord.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ProcessRecord.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ProcessRecord.KEY_ID, value);
	}
	
	@Override
	public String getStartTime() {
		return get(ProcessRecord.KEY_STARTTIME).stringValue();
	}
	
	@Override
	public void setStartTime(String value) {
		set(ProcessRecord.KEY_STARTTIME, value);
	}
	
	@Override
	public String getGid() {
		return get(ProcessRecord.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ProcessRecord.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ProcessRecord.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public String getEndTime() {
		return get(ProcessRecord.KEY_ENDTIME).stringValue();
	}
	
	@Override
	public void setEndTime(String value) {
		set(ProcessRecord.KEY_ENDTIME, value);
	}
	
}
