package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class ProcessSequenceImpl extends ManagedObjectImpl implements ProcessSequence, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProcessSequenceImpl() {
		super(LMFContext.typeForName(ProcessSequence.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ProcessSequence.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ProcessSequence.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ProcessSequence.KEY_ID, value);
	}
	
	@Override
	public Process getSource() {
		return (Process) get(ProcessSequence.KEY_SOURCE);
	}
	
	@Override
	public void setSource(Process value) {
		set(ProcessSequence.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(ProcessSequence.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ProcessSequence.KEY_GID, value);
	}
	
	@Override
	public Process getTarget() {
		return (Process) get(ProcessSequence.KEY_TARGET);
	}
	
	@Override
	public void setTarget(Process value) {
		set(ProcessSequence.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ProcessSequence.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(ProcessSequence.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(ProcessSequence.KEY_TYPE, value);
	}
	
}
