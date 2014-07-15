package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.emt.core.Element;

public interface EvidenceElement extends Element {
	
	public static final String TYPE_NAME = "evidence.EvidenceElement";
	public static final String KEY_NAME = "name";
	
	
	public String getName();
	
	public void setName(String value);
	
}
