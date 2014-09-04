package cn.edu.buaa.exLmf.manager;

import java.util.List;

import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LModelElement;

public class LEnulLiteralSearcher extends LModelSearcher{

	@Override
	public void verifyElement() throws Exception {
		if(this.element==null||!(this.element instanceof LEnumLiteral))
			throw this.getException("verifyElement()","element","Not Literal");
	}

	@Override
	public LModelElement nextElement(String name) throws Exception {
		this.nullVerify(name);
		this.verifyElement();
		
		LEnumLiteral l = (LEnumLiteral) this.element;

		if(name.equals(CONTAINER))return l.getContainer();
		
		throw this.getException("nextElement(name)", "name", "Invalid Argument: "+name);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List nextElements(String name) throws Exception {
		this.nullVerify(name);
		this.verifyElement();
		
		throw this.getException("nextElements(name)", "name", "Invalid Argument: "+name);
	}
}
