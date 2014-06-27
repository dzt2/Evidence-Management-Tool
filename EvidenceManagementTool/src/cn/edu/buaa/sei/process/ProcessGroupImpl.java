package cn.edu.buaa.sei.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ProcessGroupImpl extends ManagedObjectImpl implements ProcessGroup, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProcessGroupImpl() {
		super(LMFContext.typeForName(ProcessGroup.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ProcessGroup.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ProcessGroup.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ProcessGroup.KEY_ID, value);
	}
	
	@Override
	public List<Process> getProcesses() {
		return get(ProcessGroup.KEY_PROCESSES).listContent().toGenericList(Process.class);
	}
	
	@Override
	public String getName() {
		return get(ProcessGroup.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ProcessGroup.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ProcessGroup.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ProcessGroup.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ProcessGroup.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
