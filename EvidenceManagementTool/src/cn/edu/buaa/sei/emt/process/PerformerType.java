package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface PerformerType extends ManagedObject {
	
	public static final String TYPE_NAME = "process.PerformerType";
	
	public static final int ENUM_PLAN = 2;
	public static final int ENUM_REVIEW = 1;
	public static final int ENUM_EXECUTE = 0;
	
}
