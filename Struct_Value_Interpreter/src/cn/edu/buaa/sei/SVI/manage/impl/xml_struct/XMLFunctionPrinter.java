package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;

public class XMLFunctionPrinter implements XMLPrinter {
	
	XMLStructPrinterContainer container;
	Document doc;
	
	XMLFunctionPrinter(XMLStructPrinterContainer container,Document doc) throws Exception{
		if(container==null||doc==null)
			throw new Exception("Null container is invalid");
		else {
			this.container=container;
			this.doc=doc;
		}
	}

	@Override
	public Element translate(Struct struct) throws Exception {
		if(struct==null)throw new Exception("Null struct is invalid");
		if(!(struct instanceof Function))throw new Exception("Function required");
		Function function = (Function) struct;
		return this.translate(function);
	}
	
	public Element translate(Function function) throws Exception{
		return null;
	}

}
