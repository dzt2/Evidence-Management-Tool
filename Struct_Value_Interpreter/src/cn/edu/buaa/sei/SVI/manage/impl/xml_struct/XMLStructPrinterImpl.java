package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.manage.IStructPrinter;
import cn.edu.buaa.sei.SVI.manage.SVIResource;
import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.manage.impl.SVIStream;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.expression.Expression;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;

public class XMLStructPrinterImpl implements IStructPrinter{
	SVIStream out;
	XMLStructPrinterContainer container;
	Document doc;
	Element root;

	@Override
	public void setOutputStream(SVIResource out) throws Exception {
		if(out==null)throw new Exception("Null resource is invalid");
		if(!(out instanceof SVIStream))throw new Exception("SVIStream required");
		this.out=(SVIStream) out;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.newDocument();
		
		this.container = new XMLStructPrinterContainer(doc);
		this.root = doc.createElement(XMLStructTags.ROOT);
		this.doc.appendChild(root);
	}

	@Override
	public void write(StructManager manager) throws Exception {
		if(manager==null)throw new Exception("Null manager is invalid");
		
		Set<Struct> structs = manager.getAllStructs();
		for(Struct struct:structs){
			this.container.addAllStruct(struct);
		}
		
		Set<Struct> rms = new HashSet<Struct>();
		Set<Struct> alls = this.container.getRMap().keySet();
		structs = new HashSet<Struct>();
		
		for(Struct s:alls){
			if(s instanceof DiscourseDomain)
				rms.add(((DiscourseDomain) s).getIterator());
			else if(s instanceof FunctionTemplate)
				rms.add(((FunctionTemplate) s).getOutput());
			
			if(s instanceof Variable||s instanceof Function||s instanceof Expression)
				structs.add(s);
		}
		
		for(Struct rs:rms){
			structs.remove(rs);
		}
		
		Set<Element> elements = new HashSet<Element>();
		for(Struct s:structs){
			XMLPrinter printer = this.container.getPrinter(s);
			if(printer==null)throw new Exception("XMLPrinter Getting Failed");
			Element ei = printer.translate(s);
			if(ei==null)
				throw new Exception("Interpretation failed at: "+s.getClass().getCanonicalName()+"@{"+s.hashCode()+"}");
			elements.add(ei);
		}
		
		for(Element ei:elements)
			this.root.appendChild(ei);
		
		// write xml file
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(this.out.getOutputStream());
		transformer.transform(source, result);
	}

}
