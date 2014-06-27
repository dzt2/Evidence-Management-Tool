package cn.edu.buaa.sei.emt.assurance;
import cn.edu.buaa.sei.lmf.ManagedObject;

public interface ProvenanceType extends ManagedObject {
	
	public static final String TYPE_NAME = "evidence.ProvenanceType";
	
	public static final int ENUM_SET = 3;
	public static final int ENUM_ATTRIBUTE = 0;
	public static final int ENUM_DERIEVEDTARGET = 5;
	public static final int ENUM_DERIVEDSOURCE = 4;
	public static final int ENUM_ELEMENT = 2;
	public static final int ENUM_PARENT = 1;
	
}
