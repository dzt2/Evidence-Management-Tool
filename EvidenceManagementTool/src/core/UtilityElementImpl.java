package core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class UtilityElementImpl extends ManagedObjectImpl implements UtilityElement, Element {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public UtilityElementImpl() {
		super(LMFContext.typeForName(UtilityElement.TYPE_NAME));
	}
	
}
