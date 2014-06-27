package cn.edu.buaa.sei.emt.assurance;

public interface InformationElement extends ArgumentElement {
	
	public static final String TYPE_NAME = "argument.InformationElement";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_EVIDENCE = "evidence";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Evidence getEvidence();
	
	public void setEvidence(Evidence value);
	
}
