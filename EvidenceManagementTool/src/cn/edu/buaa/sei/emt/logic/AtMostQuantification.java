package cn.edu.buaa.sei.emt.logic;

public interface AtMostQuantification extends Quantification {
	
	public static final String TYPE_NAME = "logicformulation.AtMostQuantification";
	public static final String KEY_UPPER_BOUND = "upper_bound";
	public static final String KEY_SCOPE = "scope";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_VARIABLE = "variable";
	public static final String KEY_DOMAIN = "domain";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public int getUpper_bound();
	
	public void setUpper_bound(int value);
	
}
