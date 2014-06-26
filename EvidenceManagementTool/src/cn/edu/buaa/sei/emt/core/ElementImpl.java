package cn.edu.buaa.sei.emt.core;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ElementImpl extends ManagedObjectImpl implements Element {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ElementImpl() {
		super(LMFContext.typeForName(Element.TYPE_NAME));
	}
	
}
