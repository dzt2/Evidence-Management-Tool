package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface ClaimState extends ManagedObject {
	
	public static final String TYPE_NAME = "safe.ClaimState";
	
	public static final int ENUM_UNSUPPORTED = 1;
	public static final int ENUM_SUPPORTED = 0;
	
}
