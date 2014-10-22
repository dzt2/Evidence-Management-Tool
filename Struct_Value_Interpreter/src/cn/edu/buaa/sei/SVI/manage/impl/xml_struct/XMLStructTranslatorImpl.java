package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.manage.XMLStructTranslator;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.expression.Expression;
import cn.edu.buaa.sei.SVI.struct.core.expression.Operator;
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
import cn.edu.buaa.sei.SVI.struct.group.Contain;
import cn.edu.buaa.sei.SVI.struct.group.GroupEqual;
import cn.edu.buaa.sei.SVI.struct.group.GroupOperator;
import cn.edu.buaa.sei.SVI.struct.group.GroupVariable;
import cn.edu.buaa.sei.SVI.struct.group.Include;
import cn.edu.buaa.sei.SVI.struct.logic.AtLeast;
import cn.edu.buaa.sei.SVI.struct.logic.AtMost;
import cn.edu.buaa.sei.SVI.struct.logic.Between;
import cn.edu.buaa.sei.SVI.struct.logic.Conjunction;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.Disjunction;
import cn.edu.buaa.sei.SVI.struct.logic.Equivalence;
import cn.edu.buaa.sei.SVI.struct.logic.Existential;
import cn.edu.buaa.sei.SVI.struct.logic.Implication;
import cn.edu.buaa.sei.SVI.struct.logic.LogicOperator;
import cn.edu.buaa.sei.SVI.struct.logic.LogicVariable;
import cn.edu.buaa.sei.SVI.struct.logic.Negation;
import cn.edu.buaa.sei.SVI.struct.logic.Universal;
import cn.edu.buaa.sei.SVI.struct.numeric.NaturalVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericOperator;
import cn.edu.buaa.sei.SVI.struct.numeric.RationalVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.RealVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.ZIntegerVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Bigger;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.EBigger;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.ESmaller;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Equal;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Smaller;

public class XMLStructTranslatorImpl implements XMLStructTranslator{
	
	Document doc;
	
	Map<Struct,Element> tmap = new HashMap<Struct,Element>();
	
	public XMLStructTranslatorImpl(Document doc) throws Exception{
		if(doc==null)throw new Exception("Null document is invalid");
		this.doc=doc;
	}

	@Override
	public Element translate(Struct struct) throws Exception {
		if(struct==null)throw new Exception("Null struct is invalid");
		
		return null;
	}
	
	protected Element createVariable(Variable variable) throws Exception{
		if(variable==null)throw new Exception("Null variable is invalid");
		if(this.tmap.containsKey(variable))return this.tmap.get(variable);
		
		Element element = doc.createElement(XMLStructTags.VARIABLE);
		
		String name = variable.getName();
		String type = this.getType(variable);
		if(type==null)throw new Exception("Unknown type");
		element.setAttribute(XMLStructTags.NAME, name);
		element.setAttribute(XMLStructTags.TYPE, type);
		
		if(variable instanceof DiscourseDomain){
			Variable itor = ((DiscourseDomain) variable).getIterator();
			Element ie = doc.createElement(XMLStructTags.DISCOURSE_DOMAIN_ITER);
			ie.setAttribute(XMLStructTags.NAME, itor.getName());
			ie.setAttribute(XMLStructTags.TYPE, XMLStructTags.FREE_TYPE);
			this.tmap.put(itor, ie);
		}
		
		this.tmap.put(variable, element);
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

	protected Element createExpression(Expression expr) throws Exception{
		if(expr==null)throw new Exception("Null expression is invalid");
		if(this.tmap.containsKey(expr))return this.tmap.get(expr);
		
		Element element = doc.createElement(XMLStructTags.EXPRESSION);
		return element;
	}
	protected Element createOperator(Operator op) throws Exception{
		if(op==null)throw new Exception("Null op is invalid");
		if(this.tmap.containsKey(op))return this.tmap.get(op);
		
		Element element = null;
		if(op instanceof LogicOperator){
			if(op instanceof Negation){element = doc.createElement(XMLStructTags.NEGATION);}
			else if(op instanceof Conjunction){element = doc.createElement(XMLStructTags.CONJUNCTION);}
			else if(op instanceof Disjunction){element = doc.createElement(XMLStructTags.DISJUNCTION);}
			else if(op instanceof Implication){element = doc.createElement(XMLStructTags.IMPLICATION);}
			else if(op instanceof Equivalence){element = doc.createElement(XMLStructTags.EQUIVALENCE);}
			else if(op instanceof Universal){element = doc.createElement(XMLStructTags.UNIVERSAL);}
			else if(op instanceof Existential){element = doc.createElement(XMLStructTags.EXISTENTIAL);}
			else if(op instanceof AtLeast){element = doc.createElement(XMLStructTags.ATLEAST);}
			else if(op instanceof AtMost){element = doc.createElement(XMLStructTags.ATMOST);}
			else if(op instanceof Between){}
			else if(op instanceof Bigger){}
			else if(op instanceof EBigger){}
			else if(op instanceof Equal){}
			else if(op instanceof ESmaller){}
			else if(op instanceof Smaller){}
			else if(op instanceof Include){}
			else if(op instanceof Contain){}
			else if(op instanceof GroupEqual){}
			else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		}
		else if(op instanceof NumericOperator){}
		else if(op instanceof GroupOperator){}
		else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		
		return null;
	}
	
	@Override
	public Struct retranslate(Element element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
