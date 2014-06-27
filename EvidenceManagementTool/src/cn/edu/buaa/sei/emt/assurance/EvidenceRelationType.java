package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface EvidenceRelationType extends ManagedObject {
	
	public static final String TYPE_NAME = "evidence.EvidenceRelationType";
	
	public static final int ENUM_INCLUDEDBY = 0;
	public static final int ENUM_INCLUDE = 1;
	public static final int ENUM_ATTRIBUTEOF = 2;
	public static final int ENUM_PARENTOF = 3;
	public static final int ENUM_BASEDON = 5;
	public static final int ENUM_DERIVEDFROM = 4;
	
}
