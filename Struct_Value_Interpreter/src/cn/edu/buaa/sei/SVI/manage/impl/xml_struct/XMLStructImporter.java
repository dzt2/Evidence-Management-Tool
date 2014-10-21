package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.io.File;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.SVI.manage.IStructImporter;
import cn.edu.buaa.sei.SVI.manage.SVIResource;
import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.manage.impl.SVIFile;
import cn.edu.buaa.sei.SVI.manage.impl.StructManagerImpl;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class XMLStructImporter implements IStructImporter{
	
	SVIFile in;
	Element root;
	XMLStructImporterContainer container;
	
	@Override
	public void setInput(SVIResource in) throws Exception {
		if(in==null)throw new Exception("Null input stream is invalid");
		if(!(in instanceof SVIFile))throw new Exception("SVIFile required");
		this.in=(SVIFile) in;
		
		File file = this.in.getFile();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		
		root = (Element) doc.getChildNodes().item(0);
		this.container = new XMLStructImporterContainer(this.root);
	}

	@Override
	public StructManager read() throws Exception {
		if(this.root==null)throw new Exception("File has not been read");
		NodeList list = this.root.getChildNodes();
		
		for(int i=0;i<list.getLength();i++)
			if(list.item(i) instanceof Element){
				Element ei = (Element) list.item(i);
				XMLInterpreter interpreter = this.container.getInterpreter(ei);
				interpreter.read(ei);
			}
		
		Map<String,Struct> results = this.container.getResults();
		Set<String> ids = results.keySet();
		
		StructManager manager = new StructManagerImpl();
		for(String id:ids){
			manager.put(id, results.get(id));
		}
		return manager;
	}

}
