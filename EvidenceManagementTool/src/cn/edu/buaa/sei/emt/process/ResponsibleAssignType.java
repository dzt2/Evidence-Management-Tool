package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface ResponsibleAssignType extends ManagedObject {
	
	public static final String TYPE_NAME = "process.ResponsibleAssignType";
	
	public static final int ENUM_MODIFY = 2;
	public static final int ENUM_EVALUATE = 3;
	public static final int ENUM_OWN = 4;
	public static final int ENUM_CREATE = 0;
	public static final int ENUM_REMOVE = 1;
	public static final int ENUM_APPROVE = 5;
	
}
