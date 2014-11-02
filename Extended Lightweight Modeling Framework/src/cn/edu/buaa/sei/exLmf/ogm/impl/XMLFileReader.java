package cn.edu.buaa.sei.exLmf.ogm.impl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.exLmf.metamodel.LPackage;
import cn.edu.buaa.sei.exLmf.ogm.IObjectWorld;
import cn.edu.buaa.sei.exLmf.ogm.OGResource;
import cn.edu.buaa.sei.exLmf.ogm.OGResourceReader;

public class XMLFileReader implements OGResourceReader{
	
	OG_XMLFile resource;
	IObjectWorld cache;
	Element root;
	
	public XMLFileReader(LPackage template) throws Exception{
		if(template==null)throw new Exception("Null model template is invalid");
		this.cache = new ObjectWorld();
		this.cache.loadModelSpace(template);
	}
	
	@Override
	public IObjectWorld getCache() {return this.cache;}

	@Override
	public void read() throws Exception{
		if(this.resource==null)throw new Exception("No resource is ready to be read...");
		this.readRoot();
	}
	protected void readRoot() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(this.resource.getFile());
		NodeList list = document.getElementsByTagName(OG_XMLFile.ROOT);
		
		if(list==null||list.getLength()!=1)
			throw new Exception("Invalid Structure: exactly 1 <root> is required in XML file: "+this.resource.getFile().getAbsolutePath());
		
		this.root = (Element) list.item(0);
		System.out.println("XML Resource \""+this.resource.getFile().getAbsolutePath()+"\" has been imported into JDOM...");
	}

	@Override
	public void setResource(OGResource resource) throws Exception {
		if(resource==null)throw new Exception("Null resource is invalid");
		if(!(resource instanceof OG_XMLFile))throw new Exception("XML File required...");
		this.resource = (OG_XMLFile) resource;
	}

}
