package cn.edu.buaa.sei.emt.process;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface ProcessSequenceType extends ManagedObject {
	
	public static final String TYPE_NAME = "process.ProcessSequenceType";
	
	public static final int ENUM_ENDTOSTART = 2;
	public static final int ENUM_STARTTOEND = 1;
	public static final int ENUM_STARTTOSTART = 0;
	public static final int ENUM_ENDTOEND = 3;
	
}
