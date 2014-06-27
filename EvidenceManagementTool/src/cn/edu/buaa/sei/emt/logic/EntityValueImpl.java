package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EntityValueImpl extends ManagedObjectImpl implements EntityValue, EntityElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EntityValueImpl() {
		super(LMFContext.typeForName(EntityValue.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EntityValue.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EntityValue.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EntityValue.KEY_ID, value);
	}
	
	@Override
	public String getGid() {
		return get(EntityValue.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EntityValue.KEY_GID, value);
	}
	
	@Override
	public String getStringValue() {
		return get(EntityValue.KEY_STRINGVALUE).stringValue();
	}
	
	@Override
	public void setStringValue(String value) {
		set(EntityValue.KEY_STRINGVALUE, value);
	}
	
	@Override
	public double getDoubleValue() {
		return get(EntityValue.KEY_DOUBLEVALUE).doubleValue();
	}
	
	@Override
	public void setDoubleValue(double value) {
		set(EntityValue.KEY_DOUBLEVALUE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EntityValue.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public float getFloatValue() {
		return get(EntityValue.KEY_FLOATVALUE).floatValue();
	}
	
	@Override
	public void setFloatValue(float value) {
		set(EntityValue.KEY_FLOATVALUE, value);
	}
	
	@Override
	public boolean getBoolValue() {
		return get(EntityValue.KEY_BOOLVALUE).boolValue();
	}
	
	@Override
	public void setBoolValue(boolean value) {
		set(EntityValue.KEY_BOOLVALUE, value);
	}
	
	@Override
	public int getType() {
		return get(EntityValue.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(EntityValue.KEY_TYPE, value);
	}
	
	@Override
	public int getIntValue() {
		return get(EntityValue.KEY_INTVALUE).intValue();
	}
	
	@Override
	public void setIntValue(int value) {
		set(EntityValue.KEY_INTVALUE, value);
	}
	
}
