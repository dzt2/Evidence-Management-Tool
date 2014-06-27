package cn.edu.buaa.sei.emt.assurance;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class EvidenceRecordImpl extends ManagedObjectImpl implements EvidenceRecord, BasicEvidence {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public EvidenceRecordImpl() {
		super(LMFContext.typeForName(EvidenceRecord.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(EvidenceRecord.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(EvidenceRecord.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(EvidenceRecord.KEY_ID, value);
	}
	
	@Override
	public String getName() {
		return get(EvidenceRecord.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(EvidenceRecord.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(EvidenceRecord.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(EvidenceRecord.KEY_GID, value);
	}
	
	@Override
	public String getStringValue() {
		return get(EvidenceRecord.KEY_STRINGVALUE).stringValue();
	}
	
	@Override
	public void setStringValue(String value) {
		set(EvidenceRecord.KEY_STRINGVALUE, value);
	}
	
	@Override
	public double getDoubleValue() {
		return get(EvidenceRecord.KEY_DOUBLEVALUE).doubleValue();
	}
	
	@Override
	public void setDoubleValue(double value) {
		set(EvidenceRecord.KEY_DOUBLEVALUE, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(EvidenceRecord.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public List<EvidenceProperty> getProperties() {
		return get(EvidenceRecord.KEY_PROPERTIES).listContent().toGenericList(EvidenceProperty.class);
	}
	
	@Override
	public float getFloatValue() {
		return get(EvidenceRecord.KEY_FLOATVALUE).floatValue();
	}
	
	@Override
	public void setFloatValue(float value) {
		set(EvidenceRecord.KEY_FLOATVALUE, value);
	}
	
	@Override
	public boolean getBoolValue() {
		return get(EvidenceRecord.KEY_BOOLVALUE).boolValue();
	}
	
	@Override
	public void setBoolValue(boolean value) {
		set(EvidenceRecord.KEY_BOOLVALUE, value);
	}
	
	@Override
	public int getType() {
		return get(EvidenceRecord.KEY_TYPE).intValue();
	}
	
	@Override
	public void setType(int value) {
		set(EvidenceRecord.KEY_TYPE, value);
	}
	
	@Override
	public int getIntValue() {
		return get(EvidenceRecord.KEY_INTVALUE).intValue();
	}
	
	@Override
	public void setIntValue(int value) {
		set(EvidenceRecord.KEY_INTVALUE, value);
	}
	
}
