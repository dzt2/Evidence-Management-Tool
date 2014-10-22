package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.FreeVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.BooleanVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.CharacterVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.DoubleVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.FloatVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.IntegerVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.ListVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.LongVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.MapVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.SetVariable;
import cn.edu.buaa.sei.SVI.struct.core.variable.base.StringVariable;
import cn.edu.buaa.sei.SVI.struct.group.GroupVariable;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.LogicVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.NaturalVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.RationalVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.RealVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.ZIntegerVariable;

public class XMLVariablePrinter implements XMLPrinter{
	XMLStructPrinterContainer container;
	Document doc;
	
	XMLVariablePrinter(XMLStructPrinterContainer container,Document doc) throws Exception{
		if(container==null||doc==null)
			throw new Exception("Null container is invalid");
		else {
			this.container=container;
			this.doc=doc;
		}
	}
	
	public Element translate(Variable variable) throws Exception{
		if(variable==null)throw new Exception("Null variable is invalid");
		
		if(this.container.containResult(variable))
			return this.container.getResult(variable);
		
		if(!this.container.getRMap().containsKey(variable))
			throw new Exception("Variable is not in the container {invalid struct}");
		
		String id = this.container.getRMap().get(variable);
		if(id==null||id.length()==0)throw new Exception("Invalid ID: "+id);
		
		Element element = doc.createElement(XMLStructTags.VARIABLE);
		element.setAttribute(XMLStructTags.ID, id);
		
		if(variable.getName()==null||variable.getName().length()==0)
			throw new Exception("Null name is invalid");
		element.setAttribute(XMLStructTags.NAME, variable.getName());
		
		String type = this.getType(variable);
		if(type==null)throw new Exception("Type Interpretation failed");
		element.setAttribute(XMLStructTags.TYPE, type);
		
		if(type.equals(XMLStructTags.DISCOURSE_DOMAIN)){
			DiscourseDomain domain = (DiscourseDomain) variable;
			Variable itor = domain.getIterator();
			
			Element ce = this.translate(itor);
			if(ce==null)throw new Exception("Iterator in DiscourseDomain interpretation failed");
			ce.setAttribute(XMLStructTags.TYPE, XMLStructTags.DISCOURSE_DOMAIN_ITER);
			
			element.appendChild(ce);
		}
		
		this.container.setResult(variable, element);
		return element;
	}
	
	protected String getType(Variable var) throws Exception{
		if(var==null)throw new Exception("Null var is invalid");
		
		if(var instanceof LogicVariable){return XMLStructTags.LOGIC_TYPE;}
		else if(var instanceof GroupVariable){return XMLStructTags.GROUP_TYPE;}
		else if(var instanceof DiscourseDomain){return XMLStructTags.DISCOURSE_DOMAIN;}
		else if(var instanceof NaturalVariable){return XMLStructTags.NUM_NATURAL_TYPE;}
		else if(var instanceof ZIntegerVariable){return XMLStructTags.NUM_INTEGER_TYPE;}
		else if(var instanceof RationalVariable){return XMLStructTags.NUM_RATIONAL_TYPE;}
		else if(var instanceof RealVariable){return XMLStructTags.NUM_REAL_TYPE;}
		else if(var instanceof BooleanVariable){return XMLStructTags.BOOLEAN_TYPE;}
		else if(var instanceof IntegerVariable){return XMLStructTags.INTEGER_TYPE;}
		else if(var instanceof LongVariable){return XMLStructTags.LONG_TYPE;}
		else if(var instanceof CharacterVariable){return XMLStructTags.CHARACTER_TYPE;}
		else if(var instanceof StringVariable){return XMLStructTags.STRING_TYPE;}
		else if(var instanceof FloatVariable){return XMLStructTags.FLOAT_TYPE;}
		else if(var instanceof DoubleVariable){return XMLStructTags.DOUBLE_TYPE;}
		else if(var instanceof ListVariable){return XMLStructTags.LIST_TYPE;}
		else if(var instanceof SetVariable){return XMLStructTags.SET_TYPE;}
		else if(var instanceof MapVariable){return XMLStructTags.MAP_TYPE;}
		else if(var instanceof FreeVariable){return XMLStructTags.FREE_TYPE;}
		else throw new Exception("Unknown Variable Type: {"+var.getClass().getCanonicalName()+"}@"+var.getName());
	}

	@Override
	public Element translate(Struct struct) throws Exception {
		if(struct==null)throw new Exception("Null struct is invalid");
		if(!(struct instanceof Variable))throw new Exception("Variable required");
		Variable variable = (Variable) struct;
		return this.translate(variable);
	}
}
