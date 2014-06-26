package cn.edu.buaa.sei.emt.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class AnnotationImpl extends ManagedObjectImpl implements Annotation, UtilityElement {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public AnnotationImpl() {
		super(LMFContext.typeForName(Annotation.TYPE_NAME));
	}
	
	@Override
	public String getContent() {
		return get(Annotation.KEY_CONTENT).stringValue();
	}
	
	@Override
	public void setContent(String value) {
		set(Annotation.KEY_CONTENT, value);
	}
	
}
