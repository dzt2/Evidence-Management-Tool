package cn.edu.buaa.sei.process;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface ProcessParameterType extends ManagedObject {
	
	public static final String TYPE_NAME = "process.ProcessParameterType";
	
	public static final int ENUM_IN = 0;
	public static final int ENUM_INOUT = 2;
	public static final int ENUM_OUT = 1;
	
}
