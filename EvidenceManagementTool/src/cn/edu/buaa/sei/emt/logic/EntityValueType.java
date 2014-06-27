package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface EntityValueType extends ManagedObject {
	
	public static final String TYPE_NAME = "data.EntityValueType";
	
	public static final int ENUM_DOUBLE = 3;
	public static final int ENUM_INTEGER = 1;
	public static final int ENUM_BOOLEAN = 0;
	public static final int ENUM_STRING = 4;
	public static final int ENUM_FLOAT = 2;
	
}
