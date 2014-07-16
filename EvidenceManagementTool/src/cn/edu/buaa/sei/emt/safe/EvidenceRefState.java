package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface EvidenceRefState extends ManagedObject {
	
	public static final String TYPE_NAME = "safe.EvidenceRefState";
	
	public static final int ENUM_INITIAL = 0;
	public static final int ENUM_READY = 2;
	public static final int ENUM_UNREADY = 1;
	public static final int ENUM_DISPOSED = 3;
	
}
