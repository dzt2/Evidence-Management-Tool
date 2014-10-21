package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public interface XMLInterpreter {
	public Struct read(Element element) throws Exception;
}
