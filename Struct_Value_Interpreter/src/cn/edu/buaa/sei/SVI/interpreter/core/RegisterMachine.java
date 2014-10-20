package cn.edu.buaa.sei.SVI.interpreter.core;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.edu.buaa.sei.SVI.interpreter.core.impl.MInterpreterRegister;
import cn.edu.buaa.sei.SVI.interpreter.core.impl.SInterpreterRegister;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;

public class RegisterMachine {
	public static final String XMLROOT = "RegisterMap";
	public static final String XMLPAIR = "Pair";
	public static final String XMLSTRUCT = "Struct";
	public static final String XMLINTERPRETER = "Interpreter";
	
	public static final String ROOTTYPE = "type";
	public static final String DYNAMIC = "dynamic";
	public static final String STATIC = "static";
	
	public static InterpreterRegister register;
	
	static{
		// Register System Interpreter into the System Struct {Logic/Numeric/Group}
		register(RegisterMachine.class.getClassLoader().getResourceAsStream("config/regist.xml"));
	}
	
	public static void main(String[] args){
		try {
			System.out.println(register.get(LogicFactory.createLogicVariable("x")).getClass().getCanonicalName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static InterpreterRegister getRegister(){return register;}
	
	@SuppressWarnings("rawtypes")
	public static void register(InputStream file){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = (Element) doc.getChildNodes().item(0);
			
			Attr attr = root.getAttributeNode("type");
			if(attr.getValue().equals(DYNAMIC)){
				register = MInterpreterRegister.register;
			}
			else if(attr.getValue().equals(STATIC)){
				register = SInterpreterRegister.register;
			}
			else{throw new Exception("Wrong Attribute Value: "+attr.getTextContent());}
			
			NodeList pairs = root.getElementsByTagName(XMLPAIR);
			for(int i=0;i<pairs.getLength();i++){
				Element pair = (Element) pairs.item(i);
				String struct_name = pair.getElementsByTagName(XMLSTRUCT).item(0).getTextContent();
				String interpreter_name = pair.getElementsByTagName(XMLINTERPRETER).item(0).getTextContent();
				
				Class stype = Class.forName(struct_name);
				Class itype = Class.forName(interpreter_name);
				
				if(stype==null)
					throw new Exception("Unknown Struct Class Name: "+struct_name);
				if(itype==null)
					throw new Exception("Unknown Interpreter Class Name: "+interpreter_name);
				
				register.register(stype, itype);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
