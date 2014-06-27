package cn.edu.buaa.sei.emt.assurance;
import java.util.List;

public interface ClaimsRelation extends AssertionRelation {
	
	public static final String TYPE_NAME = "argument.ClaimsRelation";
	public static final String KEY_NAME = "name";
	public static final String KEY_TYPE = "type";
	public static final String KEY_SUB_CLAIMS = "sub_claims";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_GID = "gid";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	public static final String KEY_OBJECTIVE = "objective";
	
	
	public List<Claim> getSub_claims();
	
	public int getType();
	
	public void setType(int value);
	
}
