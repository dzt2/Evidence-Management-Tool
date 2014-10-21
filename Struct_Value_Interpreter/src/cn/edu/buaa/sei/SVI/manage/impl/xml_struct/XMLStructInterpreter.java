package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public interface XMLStructInterpreter {
	public Struct getStruct(Element element) throws Exception;
	public Element getElement(Struct struct) throws Exception;
}
