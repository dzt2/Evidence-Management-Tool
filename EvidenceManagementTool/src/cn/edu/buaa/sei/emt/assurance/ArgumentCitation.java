package cn.edu.buaa.sei.emt.assurance;

public interface ArgumentCitation extends ArgumentElement {
	
	public static final String TYPE_NAME = "argument.ArgumentCitation";
	public static final String KEY_ARGUMENTATION = "argumentation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public Argumentation getArgumentation();
	
	public void setArgumentation(Argumentation value);
	
}
