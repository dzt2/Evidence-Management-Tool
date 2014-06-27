package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class ProcessParameterImpl extends ManagedObjectImpl implements ProcessParameter, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ProcessParameterImpl() {
		super(LMFContext.typeForName(ProcessParameter.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ProcessParameter.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ProcessParameter.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ProcessParameter.KEY_ID, value);
	}
	
	@Override
	public Process getProcess() {
		return (Process) get(ProcessParameter.KEY_PROCESS);
	}
	
	@Override
	public void setProcess(Process value) {
		set(ProcessParameter.KEY_PROCESS, value);
	}
	
	@Override
	public Artifact getArtifact() {
		return (Artifact) get(ProcessParameter.KEY_ARTIFACT);
	}
	
	@Override
	public void setArtifact(Artifact value) {
		set(ProcessParameter.KEY_ARTIFACT, value);
	}
	
	@Override
	public String getGid() {
		return get(ProcessParameter.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ProcessParameter.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ProcessParameter.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(ProcessParameter.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(ProcessParameter.KEY_TYPE, value);
	}
	
}
