package cn.edu.buaa.sei.emt.safe;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class SModuleImpl extends ManagedObjectImpl implements SModule, SElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public SModuleImpl() {
		super(LMFContext.typeForName(SModule.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(SModule.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(SModule.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(SModule.KEY_ID, value);
	}
	
	@Override
	public List<SModule> getSubModules() {
		return get(SModule.KEY_SUBMODULES).listContent().toGenericList(SModule.class);
	}
	
	@Override
	public List<SRelation> getRelations() {
		return get(SModule.KEY_RELATIONS).listContent().toGenericList(SRelation.class);
	}
	
	@Override
	public List<SNode> getNodes() {
		return get(SModule.KEY_NODES).listContent().toGenericList(SNode.class);
	}
	
	@Override
	public String getName() {
		return get(SModule.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(SModule.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(SModule.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(SModule.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(SModule.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
