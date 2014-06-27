package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface EvidenceEventType extends ManagedObject {
	
	public static final String TYPE_NAME = "evidence.EvidenceEventType";
	
	public static final int ENUM_MODIFY = 3;
	public static final int ENUM_DERIVE = 2;
	public static final int ENUM_EVALUATE = 5;
	public static final int ENUM_TRANSFER = 6;
	public static final int ENUM_CREATE = 0;
	public static final int ENUM_ACQUIRE = 1;
	public static final int ENUM_REVOKE = 4;
	
}
