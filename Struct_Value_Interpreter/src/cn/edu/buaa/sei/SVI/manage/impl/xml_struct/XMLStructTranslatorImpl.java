package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.manage.XMLStructTranslator;
import cn.edu.buaa.sei.SVI.struct.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.expression.Expression;
import cn.edu.buaa.sei.SVI.struct.core.expression.Operator;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionTemplate;
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
import cn.edu.buaa.sei.SVI.struct.group.Cardinality;
import cn.edu.buaa.sei.SVI.struct.group.CartesianProduct;
import cn.edu.buaa.sei.SVI.struct.group.Complement;
import cn.edu.buaa.sei.SVI.struct.group.Contain;
import cn.edu.buaa.sei.SVI.struct.group.Difference;
import cn.edu.buaa.sei.SVI.struct.group.GroupEqual;
import cn.edu.buaa.sei.SVI.struct.group.GroupFunction;
import cn.edu.buaa.sei.SVI.struct.group.GroupOperator;
import cn.edu.buaa.sei.SVI.struct.group.GroupVariable;
import cn.edu.buaa.sei.SVI.struct.group.Include;
import cn.edu.buaa.sei.SVI.struct.group.Intersection;
import cn.edu.buaa.sei.SVI.struct.group.Union;
import cn.edu.buaa.sei.SVI.struct.group.extend.FilterTemplate;
import cn.edu.buaa.sei.SVI.struct.group.extend.MapTemplate;
import cn.edu.buaa.sei.SVI.struct.group.extend.TableMapTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.AtLeast;
import cn.edu.buaa.sei.SVI.struct.logic.AtMost;
import cn.edu.buaa.sei.SVI.struct.logic.Between;
import cn.edu.buaa.sei.SVI.struct.logic.Conjunction;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.Disjunction;
import cn.edu.buaa.sei.SVI.struct.logic.Equivalence;
import cn.edu.buaa.sei.SVI.struct.logic.Existential;
import cn.edu.buaa.sei.SVI.struct.logic.Implication;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicOperator;
import cn.edu.buaa.sei.SVI.struct.logic.LogicVariable;
import cn.edu.buaa.sei.SVI.struct.logic.Negation;
import cn.edu.buaa.sei.SVI.struct.logic.Universal;
import cn.edu.buaa.sei.SVI.struct.numeric.Addition;
import cn.edu.buaa.sei.SVI.struct.numeric.Division;
import cn.edu.buaa.sei.SVI.struct.numeric.Mod;
import cn.edu.buaa.sei.SVI.struct.numeric.Multiplication;
import cn.edu.buaa.sei.SVI.struct.numeric.NaturalVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericFunction;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericOperator;
import cn.edu.buaa.sei.SVI.struct.numeric.RationalVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.RealVariable;
import cn.edu.buaa.sei.SVI.struct.numeric.Substraction;
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
		
		this.createElement(struct);
		
		return null;
	}
	protected void createElement(Struct top) throws Exception{
		if(top==null)throw new Exception("Null top is invalid");
		if(this.tmap.containsKey(top))return;
		
		Queue<Struct> queue = new LinkedList<Struct>();
		queue.add(top);
		
		while(!queue.isEmpty()){
			top = queue.poll();
			if(this.tmap.containsKey(top))continue;
			
			if(top instanceof Variable){}
			else if(top instanceof Expression){}
			else if(top instanceof Function){}
			else if(top instanceof FunctionTemplate){}
			else if(top instanceof Operator){}
			
			if(top instanceof CompositeStruct){
				Struct[] children = ((CompositeStruct) top).getChildrenStructs();
				int n = ((CompositeStruct) top).getChildrenStructSize();
				for(int i=0;i<n;i++)
					queue.add(children[i]);
			}
		}
		
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
			else if(op instanceof Between){element = doc.createElement(XMLStructTags.BETWEEN);}
			else if(op instanceof Bigger){element = doc.createElement(XMLStructTags.BIGGER);}
			else if(op instanceof EBigger){element = doc.createElement(XMLStructTags.EBIGGER);}
			else if(op instanceof Equal){element = doc.createElement(XMLStructTags.EQUAL);}
			else if(op instanceof ESmaller){element = doc.createElement(XMLStructTags.ESMALLER);}
			else if(op instanceof Smaller){element = doc.createElement(XMLStructTags.SMALLER);}
			else if(op instanceof Include){element = doc.createElement(XMLStructTags.INCLUDE);}
			else if(op instanceof Contain){element = doc.createElement(XMLStructTags.COMPLEMENT);}
			else if(op instanceof GroupEqual){element = doc.createElement(XMLStructTags.GROUP_EQUAL);}
			else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		}
		else if(op instanceof NumericOperator){
			if(op instanceof Addition){element = doc.createElement(XMLStructTags.ADD);}
			else if(op instanceof Substraction){element = doc.createElement(XMLStructTags.SUB);}
			else if(op instanceof Multiplication){element = doc.createElement(XMLStructTags.MUL);}
			else if(op instanceof Division){element = doc.createElement(XMLStructTags.DIV);}
			else if(op instanceof Mod){element = doc.createElement(XMLStructTags.MOD);}
			else if(op instanceof Cardinality){element = doc.createElement(XMLStructTags.CARDINALITY);}
			else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		}
		else if(op instanceof GroupOperator){
			if(op instanceof Intersection){element = doc.createElement(XMLStructTags.INTERSECTION);}
			else if(op instanceof Union){element = doc.createElement(XMLStructTags.UNION);}
			else if(op instanceof Difference){element = doc.createElement(XMLStructTags.DIFFERENCE);}
			else if(op instanceof Complement){element = doc.createElement(XMLStructTags.COMPLEMENT);}
			else if(op instanceof CartesianProduct){element = doc.createElement(XMLStructTags.CARTESIAN_PRODUCT);}
			else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		}
		else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		
		this.tmap.put(op, element);
		return element;
	}
	protected Element createFunction(Function function) throws Exception{
		if(function==null)throw new Exception("Null function is invalid");
		if(this.tmap.containsKey(function))return this.tmap.get(function);
		
		Element element = null;
		
		if(function.getTemplate() instanceof FilterTemplate){element = doc.createElement(XMLStructTags.FILTER);}
		else if(function.getTemplate() instanceof MapTemplate){element = doc.createElement(XMLStructTags.MAPPER);}
		else if(function.getTemplate() instanceof TableMapTemplate){element = doc.createElement(XMLStructTags.TABLE_MAPPER);}
		else{
			element = doc.createElement(XMLStructTags.FUNCTION);
			//String a =XMLStructTags.LOGIC_EXPR_TYPE;
			if(function instanceof LogicFunction){element.setAttribute(XMLStructTags.TYPE, XMLStructTags.LOGIC_FUNCTION_TYPE);}
			else if(function instanceof GroupFunction){element.setAttribute(XMLStructTags.TYPE, XMLStructTags.GROUP_FUNCTION_TYPE);}
			else if(function instanceof NumericFunction){element.setAttribute(XMLStructTags.TYPE, XMLStructTags.NUM_FUNCTION_TYPE);}
			else throw new Exception("Unknown function type: "+function.getClass().getCanonicalName());
		}
		
		this.tmap.put(function, element);
		return element;
	}
	protected Element createTemplate(FunctionTemplate template) throws Exception{
		if(template==null)throw new Exception("Null template is invalid");
		if(this.tmap.containsKey(template))return this.tmap.get(template);
		
		Element element = doc.createElement(XMLStructTags.TEMPLATE);
		element.setAttribute(XMLStructTags.NAME,template.getName());
		
		this.tmap.put(template, element);
		return element;
	}
	
	Map<Struct,String> linked_set = new HashMap<Struct,String>();
	Long id=0L;
	
	private Element getCopy(Struct struct){
		String id = this.linked_set.get(struct);
		Element oe = this.tmap.get(struct);
		
		Element ce = doc.createElement(oe.getTagName());
		ce.setAttribute(XMLStructTags.REF, id);
		
		return ce;
	}
	private String nextID(){
		long times = 0;
		while(this.linked_set.containsValue(id.toString())){
			if(times>Long.MAX_VALUE)
				try {
					throw new Exception("ID Space has been used out.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			id++;times++;
		}
		return id.toString();
	}
	protected void linkVariable(Variable x) throws Exception{
		if(x==null)throw new Exception("Null variable is invalid");
		if(!this.tmap.containsKey(x)) throw new Exception("Invalid variable: not created");
		
		
		if(x instanceof DiscourseDomain){
			Element parent = this.tmap.get(x);
			Variable itor = ((DiscourseDomain) x).getIterator();
			if(this.linked_set.containsKey(itor)){
				Element ce = this.getCopy(itor);
				parent.appendChild(ce);
			}
			else{
				Element oe = this.tmap.get(itor);
				parent.appendChild(oe);
				this.linked_set.put(itor, nextID());
			}
		}
	}
	protected void linkExpression(Expression x) throws Exception{
		if(x==null)throw new Exception("Null expression is invalid");
		if(!this.tmap.containsKey(x)) throw new Exception("Invalid expression: not created");
		
		Element parent = this.tmap.get(x);
		Operator op = x.getOperator();
		
		if(this.linked_set.containsKey(op)){
			Element ce = this.getCopy(op);
			parent.appendChild(ce);
		}
		else{
			Element oe = this.tmap.get(op);
			parent.appendChild(oe);
			this.linked_set.put(op, nextID());
		}
		
	}
	
	@Override
	public Struct retranslate(Element element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
