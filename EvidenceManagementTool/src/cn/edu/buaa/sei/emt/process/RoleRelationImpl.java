package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class RoleRelationImpl extends ManagedObjectImpl implements RoleRelation, PMElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public RoleRelationImpl() {
		super(LMFContext.typeForName(RoleRelation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(RoleRelation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(RoleRelation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(RoleRelation.KEY_ID, value);
	}
	
	@Override
	public Role getSource() {
		return (Role) get(RoleRelation.KEY_SOURCE);
	}
	
	@Override
	public void setSource(Role value) {
		set(RoleRelation.KEY_SOURCE, value);
	}
	
	@Override
	public String getGid() {
		return get(RoleRelation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(RoleRelation.KEY_GID, value);
	}
	
	@Override
	public Role getTarget() {
		return (Role) get(RoleRelation.KEY_TARGET);
	}
	
	@Override
	public void setTarget(Role value) {
		set(RoleRelation.KEY_TARGET, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(RoleRelation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public int getType() {
		return get(RoleRelation.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(RoleRelation.KEY_TYPE, value);
	}
	
}
