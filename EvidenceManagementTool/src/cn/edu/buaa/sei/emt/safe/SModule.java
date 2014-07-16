package cn.edu.buaa.sei.emt.safe;
import java.util.List;

public interface SModule extends SElement {
	
	public static final String TYPE_NAME = "case.SModule";
	public static final String KEY_SUBMODULES = "subModules";
	public static final String KEY_NODES = "nodes";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_GID = "gid";
	public static final String KEY_RELATIONS = "relations";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public List<SModule> getSubModules();
	
	public List<SRelation> getRelations();
	
	public List<SNode> getNodes();
	
}
