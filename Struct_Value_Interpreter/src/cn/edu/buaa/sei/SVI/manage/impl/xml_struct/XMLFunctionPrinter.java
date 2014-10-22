package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.group.GroupFunction;
import cn.edu.buaa.sei.SVI.struct.group.extend.FilterTemplate;
import cn.edu.buaa.sei.SVI.struct.group.extend.MapTemplate;
import cn.edu.buaa.sei.SVI.struct.group.extend.TableMapTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunction;

public class XMLFunctionPrinter implements XMLPrinter {
	
	XMLStructPrinterContainer container;
	Document doc;
	
	XMLFunctionPrinter(XMLStructPrinterContainer container,Document doc) throws Exception{
		if(container==null||doc==null)
			throw new Exception("Null container is invalid");
		else {
			this.container=container;
			this.doc=doc;
		}
	}

	@Override
	public Element translate(Struct struct) throws Exception {
		if(struct==null)throw new Exception("Null struct is invalid");
		if(!(struct instanceof Function))throw new Exception("Function required");
		Function function = (Function) struct;
		return this.translate(function);
	}
	
	public Element translate(Function function) throws Exception{
		if(function==null)throw new Exception("Null function is invalid");
		
		if(this.container.containResult(function))
			return this.container.getResult(function);
		
		if(!this.container.getRMap().containsKey(function))
			throw new Exception("Function is not in the container {invalid struct}");
		
		String id = this.container.getRMap().get(function);
		if(id==null||id.length()==0)throw new Exception("Invalid ID: "+id);
		
		Element element = null;
		
		if(function.getTemplate()==null)throw new Exception("Null template is invalid");
		else if(function.getTemplate() instanceof FilterTemplate){
			element = doc.createElement(XMLStructTags.FILTER);
		}
		else if(function.getTemplate() instanceof MapTemplate){
			element = doc.createElement(XMLStructTags.MAPPER);
		}
		else if(function.getTemplate() instanceof TableMapTemplate){
			element = doc.createElement(XMLStructTags.TABLE_MAPPER);
		}
		else{
			element = doc.createElement(XMLStructTags.FUNCTION);
			
			String type = null;
			
			if(function instanceof LogicFunction)type = XMLStructTags.LOGIC_FUNCTION_TYPE;
			else if(function instanceof NumericFunction) type = XMLStructTags.NUM_FUNCTION_TYPE;
			else if(function instanceof GroupFunction)type = XMLStructTags.GROUP_FUNCTION_TYPE;
			else throw new Exception("Invalid Function: "+function.getClass().getCanonicalName());
			
			element.setAttribute(XMLStructTags.TYPE, type);
			
			Element temp_elm = this.generateTemplate(function.getTemplate());
			element.appendChild(temp_elm);
		}
		
		element.setAttribute(XMLStructTags.ID, id);
		return element;
	}
	protected Element generateTemplate(FunctionTemplate template) throws Exception{
		if(template==null)throw new Exception("Null template is invalid");
		
		Element temp_elm = doc.createElement(XMLStructTags.TEMPLATE);
		
		String name = template.getName();
		if(name==null||name.length()==0)
			throw new Exception("Null name is invalid in template");
		temp_elm.setAttribute(XMLStructTags.NAME, name);
		
		Variable[] arguments = template.getArguments();
		if(arguments!=null){
			for(int i=0;i<arguments.length;i++){
				Variable vi = arguments[i];
				XMLPrinter printer = this.container.getPrinter(vi);
				if(printer==null)
					throw new Exception("Getting Printer Failed.");
				
				Element ei = printer.translate(vi);
				if(ei==null)
					throw new Exception("Interpretation Failed at arguments["+i+"]");
				String eid = ei.getAttribute(XMLStructTags.ID);
				if(eid==null||eid.length()==0)
					throw new Exception("Null ID is invalid");
				
				Element ec = doc.createElement(ei.getTagName());
				ec.setAttribute(XMLStructTags.REF, eid);
				
				temp_elm.appendChild(ec);
			}
		}
		return temp_elm;
	}

}
