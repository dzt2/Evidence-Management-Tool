package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.expression.Expression;
import cn.edu.buaa.sei.SVI.struct.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.group.Cardinality;
import cn.edu.buaa.sei.SVI.struct.group.CartesianProduct;
import cn.edu.buaa.sei.SVI.struct.group.Complement;
import cn.edu.buaa.sei.SVI.struct.group.Contain;
import cn.edu.buaa.sei.SVI.struct.group.Difference;
import cn.edu.buaa.sei.SVI.struct.group.GroupEqual;
import cn.edu.buaa.sei.SVI.struct.group.GroupExpression;
import cn.edu.buaa.sei.SVI.struct.group.GroupOperator;
import cn.edu.buaa.sei.SVI.struct.group.Include;
import cn.edu.buaa.sei.SVI.struct.group.Intersection;
import cn.edu.buaa.sei.SVI.struct.group.Union;
import cn.edu.buaa.sei.SVI.struct.logic.AtLeast;
import cn.edu.buaa.sei.SVI.struct.logic.AtMost;
import cn.edu.buaa.sei.SVI.struct.logic.Between;
import cn.edu.buaa.sei.SVI.struct.logic.Conjunction;
import cn.edu.buaa.sei.SVI.struct.logic.Disjunction;
import cn.edu.buaa.sei.SVI.struct.logic.Equivalence;
import cn.edu.buaa.sei.SVI.struct.logic.Existential;
import cn.edu.buaa.sei.SVI.struct.logic.Implication;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicOperator;
import cn.edu.buaa.sei.SVI.struct.logic.Negation;
import cn.edu.buaa.sei.SVI.struct.logic.Universal;
import cn.edu.buaa.sei.SVI.struct.numeric.Addition;
import cn.edu.buaa.sei.SVI.struct.numeric.Division;
import cn.edu.buaa.sei.SVI.struct.numeric.Mod;
import cn.edu.buaa.sei.SVI.struct.numeric.Multiplication;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericExpression;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericOperator;
import cn.edu.buaa.sei.SVI.struct.numeric.Substraction;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Bigger;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.EBigger;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.ESmaller;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Equal;
import cn.edu.buaa.sei.SVI.struct.numeric.logic.Smaller;

public class XMLExpressionPrinter implements XMLPrinter{
	XMLStructPrinterContainer container;
	Document doc;
	
	XMLExpressionPrinter(XMLStructPrinterContainer container,Document doc) throws Exception{
		if(container==null||doc==null)
			throw new Exception("Null container is invalid");
		else {
			this.container=container;
			this.doc=doc;
		}
	}
	
	public Element translate(Expression expr) throws Exception{
		if(expr==null)throw new Exception("Null struct is invalid");
		
		if(this.container.containResult(expr))
			return this.container.getResult(expr);
		
		if(!this.container.getRMap().containsKey(expr))
			throw new Exception("Variable is not in the container {invalid struct}");
		
		String id = this.container.getRMap().get(expr);
		if(id==null||id.length()==0)throw new Exception("Invalid ID: "+id);
		
		Element element = doc.createElement(XMLStructTags.EXPRESSION);
		element.setAttribute(XMLStructTags.ID, id);
		
		if(expr instanceof LogicExpression){
			element.setAttribute(XMLStructTags.TYPE, XMLStructTags.LOGIC_EXPR_TYPE);
			this.getLogicType(((LogicExpression)expr).getOperator(), element);
		}
		else if(expr instanceof NumericExpression){
			element.setAttribute(XMLStructTags.TYPE, XMLStructTags.NUMERIC_EXPR_TYPE);
			this.getNumericType(((NumericExpression)expr).getOperator(), element);
		}
		else if(expr instanceof GroupExpression){
			element.setAttribute(XMLStructTags.TYPE, XMLStructTags.GROUP_EXPR_TYPE);
			this.getGroupType(((GroupExpression)expr).getOperator(), element);
		}
		else throw new Exception("Unknown expression: "+expr.getClass().getCanonicalName());
		
		return element;
	}
	
	protected void getLogicType(LogicOperator op,Element parent) throws Exception{
		if(op==null||parent==null)throw new Exception("Null operator|parent is invalid");
		
		Element op_elm = null;
		if(op instanceof Negation){
			op_elm = doc.createElement(XMLStructTags.NEGATION);
			this.addChildren(op_elm,new Struct[]{((Negation) op).getOperand()});
		}
		else if(op instanceof Conjunction){
			op_elm = doc.createElement(XMLStructTags.CONJUNCTION);
			
			LogicStruct[] operands = ((Conjunction) op).getOperands();
			if(operands==null||operands.length==0)
				throw new Exception("Null Operands in Operator are invalid");
			Struct[] children = new Struct[operands.length];
			for(int i=0;i<children.length;i++)
				children[i] = operands[i];
			
			this.addChildren(op_elm, children);
		}
		else if(op instanceof Disjunction){
			op_elm = doc.createElement(XMLStructTags.DISJUNCTION);
			
			LogicStruct[] operands = ((Disjunction) op).getOperands();
			if(operands==null||operands.length==0)
				throw new Exception("Null Operands in Operator are invalid");
			Struct[] children = new Struct[operands.length];
			for(int i=0;i<children.length;i++)
				children[i] = operands[i];
			
			this.addChildren(op_elm, children);
		}
		else if(op instanceof Implication){
			op_elm = doc.createElement(XMLStructTags.IMPLICATION);
			this.addChildren(op_elm, new Struct[]{((Implication) op).getLeftOperand(),((Implication) op).getRightOperand()});
		}
		else if(op instanceof Equivalence){
			op_elm = doc.createElement(XMLStructTags.EQUIVALENCE);
			this.addChildren(op_elm, new Struct[]{((Equivalence) op).getLeftOperand(),((Equivalence) op).getRightOperand()});
		}
		else if(op instanceof Universal){
			op_elm = doc.createElement(XMLStructTags.UNIVERSAL);
			this.addChildren(op_elm, new Struct[]{((Universal) op).getDomain(),((Universal) op).getScope()});
		}
		else if(op instanceof Existential){
			op_elm = doc.createElement(XMLStructTags.EXISTENTIAL);
			this.addChildren(op_elm, new Struct[]{((Existential) op).getDomain(),((Existential) op).getScope()});
		}
		else if(op instanceof AtLeast){
			op_elm = doc.createElement(XMLStructTags.ATLEAST);
			
			Integer lower = ((AtLeast) op).getLowerBound();
			op_elm.setAttribute(XMLStructTags.LOWBOUND, lower.toString());
			
			this.addChildren(op_elm, new Struct[]{((AtLeast) op).getDomain(),((AtLeast) op).getScope()});
		}
		else if(op instanceof AtMost){
			op_elm = doc.createElement(XMLStructTags.ATMOST);
			
			Integer upper= ((AtMost) op).getUpperBound();
			op_elm.setAttribute(XMLStructTags.UPBOUND, upper.toString());
			
			this.addChildren(op_elm, new Struct[]{((AtMost) op).getDomain(),((AtMost) op).getScope()});	
		}
		else if(op instanceof Between){
			op_elm = doc.createElement(XMLStructTags.BETWEEN);
			
			Integer upper = ((Between) op).getUpperBound();
			Integer lower = ((Between) op).getLowerBound();
			
			op_elm.setAttribute(XMLStructTags.LOWBOUND, lower.toString());
			op_elm.setAttribute(XMLStructTags.UPBOUND, upper.toString());
			
			this.addChildren(op_elm, new Struct[]{((Between) op).getDomain(),((Between) op).getScope()});
		}
		else if(op instanceof Bigger){
			op_elm = doc.createElement(XMLStructTags.BIGGER);
			this.addChildren(op_elm, new Struct[]{((Bigger) op).getLeftOperand(),((Bigger) op).getRightOperand()});
		}
		else if(op instanceof EBigger){
			op_elm = doc.createElement(XMLStructTags.EBIGGER);
			this.addChildren(op_elm, new Struct[]{((EBigger) op).getLeftOperand(),((EBigger) op).getRightOperand()});
		}
		else if(op instanceof Equal){
			op_elm = doc.createElement(XMLStructTags.EQUAL);
			this.addChildren(op_elm, new Struct[]{((Equal) op).getLeftOperand(),((Equal) op).getRightOperand()});
		}
		else if(op instanceof ESmaller){
			op_elm = doc.createElement(XMLStructTags.ESMALLER);
			this.addChildren(op_elm, new Struct[]{((ESmaller) op).getLeftOperand(),((ESmaller) op).getRightOperand()});
		}
		else if(op instanceof Smaller){
			op_elm = doc.createElement(XMLStructTags.SMALLER);
			this.addChildren(op_elm, new Struct[]{((Smaller) op).getLeftOperand(),((Smaller) op).getRightOperand()});
		}
		else if(op instanceof Contain){
			op_elm = doc.createElement(XMLStructTags.CONTAIN);
			this.addChildren(op_elm, new Struct[]{((Contain) op).getLeftOperand(),((Contain) op).getRightOperand()});
		}
		else if(op instanceof Include){
			op_elm = doc.createElement(XMLStructTags.INCLUDE);
			this.addChildren(op_elm, new Struct[]{((Include) op).getLeftOperand(),((Include) op).getRightOperand()});
		}
		else if(op instanceof GroupEqual){
			op_elm = doc.createElement(XMLStructTags.GROUP_EQUAL);
			this.addChildren(op_elm, new Struct[]{((GroupEqual) op).getLeftOperand(),((GroupEqual) op).getRightOperand()});
		}
		else throw new Exception("Invalid Logic Operator: "+op.getClass().getCanonicalName());
		
		if(op_elm==null)
			throw new Exception("Operator Interpretation failed: "+op.getClass().getCanonicalName());
		
		parent.appendChild(op_elm);
	}
	protected void getNumericType(NumericOperator op,Element parent) throws Exception{
		if(op==null||parent==null)throw new Exception("Null operator|parent is invalid");
		
		Element op_elm = null;
		if(op instanceof Addition){
			op_elm = doc.createElement(XMLStructTags.ADD);
			this.addChildren(op_elm, new Struct[]{((Addition) op).getLeftOperand(),((Addition) op).getRightOperand()});
		}
		else if(op instanceof Substraction){
			op_elm = doc.createElement(XMLStructTags.SUB);
			this.addChildren(op_elm, new Struct[]{((Substraction) op).getLeftOperand(),((Substraction) op).getRightOperand()});
		}
		else if(op instanceof Multiplication){
			op_elm = doc.createElement(XMLStructTags.MUL);
			this.addChildren(op_elm, new Struct[]{((Multiplication) op).getLeftOperand(),((Multiplication) op).getRightOperand()});
		}
		else if(op instanceof Division){
			op_elm = doc.createElement(XMLStructTags.DIV);
			this.addChildren(op_elm, new Struct[]{((Division) op).getLeftOperand(),((Division) op).getRightOperand()});
		}
		else if(op instanceof Mod){
			op_elm = doc.createElement(XMLStructTags.MOD);
			this.addChildren(op_elm, new Struct[]{((Mod) op).getLeftOperand(),((Mod) op).getRightOperand()});
		}
		else if(op instanceof Cardinality){
			op_elm = doc.createElement(XMLStructTags.CARDINALITY);
			this.addChildren(op_elm, new Struct[]{((Cardinality) op).getOperand()});
		}
		else throw new Exception("Invalid Numeric Operator: "+op.getClass().getCanonicalName());
		
		if(op_elm==null)
			throw new Exception("Operator Interpretation failed: "+op.getClass().getCanonicalName());
		
		parent.appendChild(op_elm);
	}
	protected void getGroupType(GroupOperator op,Element parent) throws Exception{
		if(op==null||parent==null)throw new Exception("Null operator|parent is invalid");
		
		Element op_elm = null;
		
		if(op instanceof Intersection){
			op_elm = doc.createElement(XMLStructTags.INTERSECTION);
			GroupStruct[] operands = ((Intersection) op).getOperands();
			Struct[] children = new Struct[operands.length];
			
			for(int i=0;i<children.length;i++)
				children[i]=operands[i];
			
			this.addChildren(op_elm, children);
		}
		else if(op instanceof Union){
			op_elm = doc.createElement(XMLStructTags.UNION);
			GroupStruct[] operands = ((Union) op).getOperands();
			Struct[] children = new Struct[operands.length];
			
			for(int i=0;i<children.length;i++)
				children[i]=operands[i];
			
			this.addChildren(op_elm, children);
		}
		else if(op instanceof Complement){
			op_elm = doc.createElement(XMLStructTags.COMPLEMENT);
			this.addChildren(op_elm, new Struct[]{((Complement) op).getOperand(),((Complement) op).getDomain()});
		}
		else if(op instanceof Difference){
			op_elm = doc.createElement(XMLStructTags.DIFFERENCE);
			this.addChildren(op_elm, new Struct[]{((Difference) op).getLeftOperand(),((Difference) op).getRightOperand()});
		}
		else if(op instanceof CartesianProduct){
			op_elm = doc.createElement(XMLStructTags.CARTESIAN_PRODUCT);
			GroupStruct[] operands = ((CartesianProduct) op).getOperands();
			Struct[] children = new Struct[operands.length];
			
			for(int i=0;i<children.length;i++)
				children[i]=operands[i];
			
			this.addChildren(op_elm, children);
		}
		else throw new Exception("Invalid Group Operator: "+op.getClass().getCanonicalName());
		
		if(op_elm==null)throw new Exception("Operator Interpretation failed: "+op.getClass().getCanonicalName());
		parent.appendChild(op_elm);
	}
	
	protected void addChildren(Element parent,Struct[] operands)throws Exception{
		if(operands==null||parent==null)throw new Exception("Null operands||parent is invalid");
		
		for(int i=0;i<operands.length;i++){
			XMLPrinter printer = this.container.getPrinter(operands[i]);
			if(printer==null)throw new Exception("Getting Printer failed.");
			
			Element ei = printer.translate(operands[i]);
			if(ei==null)
				throw new Exception("Interpretation failed at: operands["+i+"]");
			String id = ei.getAttribute(XMLStructTags.ID);
			if(id==null||id.length()==0)
				throw new Exception("Producing Element with null id");
			
			Element ei_cp = doc.createElement(ei.getTagName());
			ei_cp.setAttribute(XMLStructTags.REF, id);
			parent.appendChild(ei_cp);
		}
	}

	@Override
	public Element translate(Struct struct) throws Exception {
		if(struct==null)throw new Exception("Null struct is invalid");
		if(!(struct instanceof Expression))throw new Exception("Expression required");
		Expression expr = (Expression) struct;
		return this.translate(expr);
	}
	
	
}
