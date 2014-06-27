package cn.edu.buaa.sei.emt.process;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ProcessImpl extends ManagedObjectImpl implements Process, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProcessImpl() {
		super(LMFContext.typeForName(Process.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Process.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Process.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Process.KEY_ID, value);
	}
	
	@Override
	public String getName() {
		return get(Process.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Process.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Process.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Process.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Process.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<Process> getSubordinate() {
		return get(Process.KEY_SUBORDINATE).listContent().toGenericList(Process.class);
	}
	
}
