package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;
import cn.edu.buaa.sei.emt.core.ModelElement;

public class StatementImpl extends ManagedObjectImpl implements Statement, ModelElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public StatementImpl() {
		super(LMFContext.typeForName(Statement.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Statement.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Statement.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Statement.KEY_ID, value);
	}
	
	@Override
	public String getContent() {
		return get(Statement.KEY_CONTENT).stringValue();
	}
	
	@Override
	public void setContent(String value) {
		set(Statement.KEY_CONTENT, value);
	}
	
	@Override
	public String getGid() {
		return get(Statement.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Statement.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Statement.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
