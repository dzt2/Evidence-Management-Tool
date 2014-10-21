package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class XMLFunctionReader implements XMLInterpreter{
	XMLStructImporterContainer container;
	
	public XMLFunctionReader(XMLStructImporterContainer container) throws Exception {
		if(container==null)throw new Exception("Null Container is invalid");
		this.container=container;
	}

	@Override
	public Struct read(Element element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
