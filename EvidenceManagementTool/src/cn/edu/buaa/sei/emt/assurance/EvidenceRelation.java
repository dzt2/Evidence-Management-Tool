package cn.edu.buaa.sei.emt.assurance;

public interface EvidenceRelation extends EvidenceElement {
	
	public static final String TYPE_NAME = "evidence.EvidenceRelation";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_SOURCE = "source";
	public static final String KEY_TARGET = "target";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Evidence getSource();
	
	public void setSource(Evidence value);
	
	public Evidence getTarget();
	
	public void setTarget(Evidence value);
	
	public int getType();
	
	public void setType(int value);
	
}
