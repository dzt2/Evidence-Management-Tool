package cn.edu.buaa.sei.exLmf.ogm.impl;

import java.io.File;
import cn.edu.buaa.sei.exLmf.ogm.OG_File;

public class OG_XMLFile implements OG_File{
	
	public static final String ROOT = "root";
	public static final String ID = "_id";
	public static final String REF = "ref";
	
	File file;
	
	public OG_XMLFile(File file) throws Exception{
		if(file==null)throw new Exception("Null file is invalid");
		this.file = file;
		
		/*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(this.file);
		NodeList list = document.getElementsByTagName(ROOT);
		
		if(list==null||list.getLength()!=1)
			throw new Exception("Invalid Structure: exactly 1 <root> is required in XML file: "+this.file.getAbsolutePath());
		
		this.root = (Element) list.item(0);
		System.out.println("XML Resource \""+file.getAbsolutePath()+"\" has been imported into JDOM...");*/
	}
	@Override
	public File getFile() {return file;}

}
