package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface EvidenceStatusType extends ManagedObject {
	
	public static final String TYPE_NAME = "evidence.EvidenceStatusType";
	
	public static final int ENUM_INITIAL = 0;
	public static final int ENUM_READY = 2;
	public static final int ENUM_UNREADY = 1;
	public static final int ENUM_REVOKED = 3;
	
}
