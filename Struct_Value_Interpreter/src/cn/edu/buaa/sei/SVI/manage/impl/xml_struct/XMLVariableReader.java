package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.core.variable.impl.VariableFactory;
import cn.edu.buaa.sei.SVI.struct.group.impl.GroupFactory;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;
import cn.edu.buaa.sei.SVI.struct.numeric.impl.NumericFactory;

public class XMLVariableReader implements XMLInterpreter{
	
	XMLStructImporterContainer container;
	
	public XMLVariableReader(XMLStructImporterContainer container) throws Exception{
		if(container==null)throw new Exception("Null Container is invalid");
		this.container=container;
	}
	
	public Struct read(Element element) throws Exception{
		if(element==null)throw new Exception("Null element is invalid");
		
		Element oe = this.container.getOriginalElement(element);
		if(this.container.containResult(oe))
			return this.container.getResult(oe);
		
		if(oe.getTagName().equals(XMLStructTags.VARIABLE)){
			/*String id = oe.getAttribute(XMLStructTags.ID);
			if(id==null||id.length()==0)throw new Exception("ID is required in <"+element.getTagName()+">");*/
			
			String name = oe.getAttribute(XMLStructTags.NAME);
			if(name==null||name.length()==0)throw new Exception("Null name is invalid");
			String type = oe.getAttribute(XMLStructTags.TYPE);
			if(type==null||type.length()==0)throw new Exception("Null type is invalid");
			
			Variable var = this.generate(name, type,oe);
			if(var==null)throw new Exception("Interpretation failed at: "+oe.getTagName());
			
			this.container.setResult(oe, var);
			
			return var;
		}
		else if(oe.getTagName().equals(XMLStructTags.DISCOURSE_DOMAIN_ITER)){
			Element pe = (Element) oe.getParentNode();
			if(pe==null||!pe.getTagName().equals(XMLStructTags.VARIABLE)
					||!pe.getAttribute(XMLStructTags.TYPE).equals(XMLStructTags.DISCOURSE_DOMAIN))
				throw new Exception("<iterator> must be in a domain element as <Variable>");
			
			DiscourseDomain domain = (DiscourseDomain) this.read(pe);
			if(domain==null)
				throw new Exception("Parent Node interpretation failed.");
			return domain.getIterator();
		}
		else throw new Exception("Invalid Element: <"+oe.getTagName()+">");
	}
	
	protected Variable generate(String name,String type,Element parent) throws Exception{
		if(name==null||type==null||parent==null)throw new Exception("Null name|type|parent");
		
		if(type.equals(XMLStructTags.BOOLEAN_TYPE))return VariableFactory.createBoolean(name);
		else if(type.equals(XMLStructTags.INTEGER_TYPE))return VariableFactory.createInteger(name);
		else if(type.equals(XMLStructTags.LONG_TYPE))return VariableFactory.createLong(name);
		else if(type.equals(XMLStructTags.CHARACTER_TYPE))return VariableFactory.createCharacter(name);
		else if(type.equals(XMLStructTags.STRING_TYPE))return VariableFactory.createString(name);
		else if(type.equals(XMLStructTags.FLOAT_TYPE))return VariableFactory.createFloat(name);
		else if(type.equals(XMLStructTags.DOUBLE_TYPE))return VariableFactory.createDouble(name);
		else if(type.equals(XMLStructTags.LIST_TYPE))return VariableFactory.createList(name);
		else if(type.equals(XMLStructTags.MAP_TYPE))return VariableFactory.createMap(name);
		else if(type.equals(XMLStructTags.SET_TYPE))return VariableFactory.createSet(name);
		else if(type.equals(XMLStructTags.FREE_TYPE))return VariableFactory.createFreeVariable(name);
		else if(type.equals(XMLStructTags.LOGIC_TYPE))return LogicFactory.createLogicVariable(name);
		else if(type.equals(XMLStructTags.DISCOURSE_DOMAIN)){
			NodeList children = parent.getElementsByTagName(XMLStructTags.DISCOURSE_DOMAIN_ITER);
			
			if(children==null||children.getLength()!=1)throw new Exception("Exactly 1 <iterator> required in <"+parent.getTagName()+">");
			Element child = (Element) children.item(0);
			
			DiscourseDomain domain = LogicFactory.createDiscourseDomain(name);
			this.container.setResult(child, domain.getIterator());
			return domain;
		}
		else if(type.equals(XMLStructTags.NUM_NATURAL_TYPE))return NumericFactory.createNaturalVariable(name);
		else if(type.equals(XMLStructTags.NUM_INTEGER_TYPE))return NumericFactory.createZIntegerVariable(name);
		else if(type.equals(XMLStructTags.NUM_RATIONAL_TYPE))return NumericFactory.createRationalVariable(name);
		else if(type.equals(XMLStructTags.NUM_REAL_TYPE))return NumericFactory.createRealVariable(name);
		else if(type.equals(XMLStructTags.GROUP_TYPE))return GroupFactory.createGroupVariable(name);
		throw new Exception("Unknown type: "+type);
	}
	
	protected List<Element> translate(NodeList list){
		if(list==null)return null;
		List<Element> elist = new ArrayList<Element>();
		
		for(int i=0;i<list.getLength();i++)
			if(list.item(i) instanceof Element)
				elist.add((Element) list.item(i));
		
		return elist;
	} 
}
