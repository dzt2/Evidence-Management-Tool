package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.group.GroupFunction;
import cn.edu.buaa.sei.SVI.struct.group.GroupFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.group.impl.GroupFactory;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunction;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.numeric.impl.NumericFactory;

public class XMLFunctionReader implements XMLInterpreter{
	XMLStructImporterContainer container;
	
	public XMLFunctionReader(XMLStructImporterContainer container) throws Exception {
		if(container==null)throw new Exception("Null Container is invalid");
		this.container=container;
	}

	@Override
	public Struct read(Element element) throws Exception {
		if(element==null)throw new Exception("Null element is invalid");
		
		element = this.container.getOriginalElement(element);
		
		if(this.container.containResult(element))return this.container.getResult(element);
		
		if(element.getTagName().equals(XMLStructTags.FUNCTION)){
			String type = element.getAttribute(XMLStructTags.TYPE);
			
			if(type==null||type.length()==0)
				throw new Exception("Attribute type required in <"+element.getTagName()+">");
			
			NodeList list = element.getElementsByTagName(XMLStructTags.TEMPLATE);
			if(list==null||list.getLength()!=1)throw new Exception("Exactly 1 <Template> is required in <"+element.getTagName()+">");
			Element temp_elm = (Element) list.item(0);
			
			if(type.equals(XMLStructTags.LOGIC_FUNCTION_TYPE)){
				Function function = this.generateLogicFunction(temp_elm);
				this.container.setResult(element, function);
				return function;
			}
			else if(type.equals(XMLStructTags.NUM_FUNCTION_TYPE)){
				Function function = this.generateNumericFunction(temp_elm);
				this.container.setResult(element, function);
				return function;
			}
			else if(type.equals(XMLStructTags.GROUP_FUNCTION_TYPE)){
				Function function = this.generateGroupFunction(temp_elm);
				this.container.setResult(element, function);
				return function;
			}
			else throw new Exception("Unknown type attribute: \""+type+"\"");
		}
		else if(element.getTagName().equals(XMLStructTags.FILTER)){
			GroupFunction function = GroupFactory.createFilter();
			this.container.setResult(element, function);
			return function;
		}
		else if(element.getTagName().equals(XMLStructTags.MAPPER)){
			GroupFunction function = GroupFactory.createMap();
			this.container.setResult(element, function);
			return function;
		}
		else if(element.getTagName().equals(XMLStructTags.TABLE_MAPPER)){
			GroupFunction function = GroupFactory.createTableMap();
			this.container.setResult(element, function);
			return function;
		}
		else throw new Exception("Invalid Element tag: <"+element.getTagName()+">");
	}
	
	protected LogicFunction generateLogicFunction(Element temp_elm) throws Exception{
		if(temp_elm==null)throw new Exception("Null Element is invalid");
		
		String name = temp_elm.getAttribute(XMLStructTags.NAME);
		if(name==null||name.length()==0)throw new Exception("Attribute name is required in <"+temp_elm.getTagName()+">");
		
		Variable[] arguments = this.getChildren(temp_elm);
		if(arguments==null||arguments.length==0)throw new Exception("At least 1 variable required as arguments at <"+temp_elm.getTagName()+">");
		
		LogicFunctionTemplate template = LogicFactory.createLogicFunctionTemplate(name, arguments);
		return LogicFactory.createLogicFunction(template);
	}
	
	protected NumericFunction generateNumericFunction(Element temp_elm) throws Exception{
		if(temp_elm==null)throw new Exception("Null Element is invalid");
		
		String name = temp_elm.getAttribute(XMLStructTags.NAME);
		if(name==null||name.length()==0)throw new Exception("Attribute name is required in <"+temp_elm.getTagName()+">");
		
		Variable[] arguments = this.getChildren(temp_elm);
		if(arguments==null||arguments.length==0)throw new Exception("At least 1 variable required as arguments at <"+temp_elm.getTagName()+">");
		
		NumericFunctionTemplate template = NumericFactory.createNaturalFunctionTemplate(name, arguments);
		return NumericFactory.createNumericFunction(template,null,null);
	}
	
	protected GroupFunction generateGroupFunction(Element temp_elm) throws Exception{
		if(temp_elm==null)throw new Exception("Null Element is invalid");
		
		String name = temp_elm.getAttribute(XMLStructTags.NAME);
		if(name==null||name.length()==0)throw new Exception("Attribute name is required in <"+temp_elm.getTagName()+">");
		
		Variable[] arguments = this.getChildren(temp_elm);
		if(arguments==null||arguments.length==0)throw new Exception("At least 1 variable required as arguments at <"+temp_elm.getTagName()+">");
		
		GroupFunctionTemplate template = GroupFactory.createGroupFunctionTemplate(name, arguments);
		return GroupFactory.createGroupFunction(template);
	}
	
	protected Variable[] getChildren(Element top) throws Exception{
		NodeList list = top.getChildNodes();
		List<Struct> children = new ArrayList<Struct>();
		for(int i=0;i<list.getLength();i++)
			if(list.item(i) instanceof Element){
				Element ei = (Element) list.item(i);
				XMLInterpreter interpreter = this.container.getInterpreter(ei);
				children.add(interpreter.read(ei));
			}
				
		Variable[] cs = new Variable[children.size()];
		for(int i=0;i<cs.length;i++)
			cs[i]=(Variable) children.get(i);
		
		return cs;
	}

}
