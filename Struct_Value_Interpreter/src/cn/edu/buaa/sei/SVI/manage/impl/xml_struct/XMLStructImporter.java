package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.manage.IStructImporter;
import cn.edu.buaa.sei.SVI.manage.SVIResource;
import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.manage.impl.SVIFile;

public class XMLStructImporter implements IStructImporter{
	SVIFile resource;
	
	Element root;
	
	@Override
	public void setInput(SVIResource in) throws Exception {
		if(in==null)throw new Exception("Null resource is invalid");
		if(!(in instanceof SVIFile))throw new Exception("SVIFile required");
		this.resource=(SVIFile) in;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		builder = factory.newDocumentBuilder();
		Document doc = builder.parse(this.resource.getFile());
		root = (Element) doc.getChildNodes().item(0);
	}

	@Override
	public StructManager read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
