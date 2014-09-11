package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.edu.buaa.sei.exLmf.manager.IModelPrinter;
import cn.edu.buaa.sei.exLmf.manager.impl.ModelPrinter;
import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LClassifier;
import cn.edu.buaa.sei.exLmf.metamodel.LEnum;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public class Test {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document document = db.parse("test.lmfmeta"); 
			NodeList list = document.getChildNodes();
			Node root = list.item(0);
			System.out.println(root.getNodeName()+" -- "+root.getChildNodes().getLength());
			Node c1 = root.getChildNodes().item(0);
			System.out.println(c1.getNodeName()+" -- "+c1.getChildNodes().getLength());
			System.out.println(c1.getTextContent());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void testEcore(){
		IModelImporter im = new EcoreModelImporter("IMPORT");
		im.setResource(new File("test.ecore"));
		try {
			LPackage p = im.translate();
			IModelPrinter printer = new ModelPrinter("Printer");
			System.out.println(printer.printLPackage(p));
			
			List<LClassifier> types = p.getTypes();
			for(int i=0;i<types.size();i++){
				if(types.get(i) instanceof LClass)
					System.out.println(printer.printLClass((LClass) types.get(i)));
				else if(types.get(i) instanceof LEnum)
					System.out.println(printer.printLEnum((LEnum) types.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
