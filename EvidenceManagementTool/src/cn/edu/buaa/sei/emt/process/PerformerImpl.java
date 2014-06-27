package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PerformerImpl extends ManagedObjectImpl implements Performer, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PerformerImpl() {
		super(LMFContext.typeForName(Performer.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Performer.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Performer.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Performer.KEY_ID, value);
	}
	
	@Override
	public Process getProcess() {
		return (Process) get(Performer.KEY_PROCESS);
	}
	
	@Override
	public void setProcess(Process value) {
		set(Performer.KEY_PROCESS, value);
	}
	
	@Override
	public String getGid() {
		return get(Performer.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Performer.KEY_GID, value);
	}
	
	@Override
	public Role getRole() {
		return (Role) get(Performer.KEY_ROLE);
	}
	
	@Override
	public void setRole(Role value) {
		set(Performer.KEY_ROLE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Performer.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(Performer.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(Performer.KEY_TYPE, value);
	}
	
}
