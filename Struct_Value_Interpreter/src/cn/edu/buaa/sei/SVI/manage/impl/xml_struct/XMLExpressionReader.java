package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.NumericStruct;
import cn.edu.buaa.sei.SVI.struct.group.GroupExpression;
import cn.edu.buaa.sei.SVI.struct.group.impl.GroupFactory;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;
import cn.edu.buaa.sei.SVI.struct.numeric.NumericExpression;
import cn.edu.buaa.sei.SVI.struct.numeric.impl.NumericFactory;

public class XMLExpressionReader implements XMLInterpreter{
	XMLStructImporterContainer container;
	
	public XMLExpressionReader(XMLStructImporterContainer container) throws Exception{
		if(container==null)throw new Exception("Null Container is invalid");
		this.container=container;
	}
	
	public Struct read(Element element) throws Exception{
		if(element==null)throw new Exception("Null element is invalid");
		
		element = this.container.getOriginalElement(element);
		if(element.getTagName().equals(XMLStructTags.EXPRESSION)){
			if(this.container.containResult(element))return this.container.getResult(element);
			
			String type = element.getAttribute(XMLStructTags.TYPE);
			if(type==null||type.length()==0)throw new Exception("Type Attribute Undefined: <"+element.getTagName()+">");
			
			List<Element> list = this.translate(element.getChildNodes());
			
			
			if(list==null||list.size()!=1)
				throw new Exception("Invalid Structure in <expression>: only 1 child is needed");
			Element op = list.get(0);
			
			if(type.equals(XMLStructTags.LOGIC_EXPR_TYPE)){
				LogicExpression expr = this.generateLogicExpression(op);
				this.container.setResult(element, expr);
				return expr;
			}
			else if(type.equals(XMLStructTags.NUMERIC_EXPR_TYPE)){
				NumericExpression expr = this.generateNumericExpression(op);
				this.container.setResult(element, expr);
				return expr;
			}
			else if(type.equals(XMLStructTags.GROUP_EXPR_TYPE)){
				GroupExpression expr = this.generateGroupExpression(op);
				this.container.setResult(element, expr);
				return expr;
			}
			else throw new Exception("Unknown Type in <Function>: "+type);
		}
		else throw new Exception("Invalid Element: <"+element.getTagName()+">");
	}
	
	protected LogicExpression generateLogicExpression(Element op) throws Exception{
		if(op==null)throw new Exception("Null element is invalid");
		
		String tag = op.getTagName();
		
		NodeList children = op.getChildNodes();
		List<Element> child_elms = this.translate(children);
		
		if(tag.equals(XMLStructTags.CONJUNCTION)){
			if(child_elms.size()<2)throw new Exception("At least 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			LogicStruct[] rrs = new LogicStruct[rs.length];
			
			for(int i=0;i<rrs.length;i++)rrs[i]=(LogicStruct) rs[i];
			
			return LogicFactory.createConjunction(rrs);
		}
		else if(tag.equals(XMLStructTags.DISJUNCTION)){
			if(child_elms.size()<2)throw new Exception("At least 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			LogicStruct[] rrs = new LogicStruct[rs.length];
			
			for(int i=0;i<rrs.length;i++)rrs[i]=(LogicStruct) rs[i];
			
			return LogicFactory.createDisjunction(rrs);
		}
		else if(tag.equals(XMLStructTags.NEGATION)){
			if(child_elms.size()!=1)throw new Exception("Exactly 1 operand required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return LogicFactory.createNegation((LogicStruct) rs[0]);
		}
		else if(tag.equals(XMLStructTags.IMPLICATION)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return LogicFactory.createImplication((LogicStruct)rs[0], (LogicStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.EQUIVALENCE)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return LogicFactory.createEquivalence((LogicStruct)rs[0], (LogicStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.UNIVERSAL)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			/*if(!child_elms.get(0).getTagName().equals(XMLStructTags.VARIABLE))
				throw new Exception("<Variable> required at first child of <"+tag+">");
			String vtype = child_elms.get(0).getAttribute(XMLStructTags.TYPE);
			if(vtype==null||!vtype.equals(XMLStructTags.DISCOURSE_DOMAIN))
				throw new Exception("<Variable> attribute type need to be <domain>");*/
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return LogicFactory.createUniversal((DiscourseDomain)rs[0], (LogicStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.EXISTENTIAL)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			/*if(!child_elms.get(0).getTagName().equals(XMLStructTags.VARIABLE))
				throw new Exception("<Variable> required at first child of <"+tag+">");
			String vtype = child_elms.get(0).getAttribute(XMLStructTags.TYPE);
			if(vtype==null||!vtype.equals(XMLStructTags.DISCOURSE_DOMAIN))
				throw new Exception("<Variable> attribute type need to be domain");*/
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return LogicFactory.createExistential((DiscourseDomain)rs[0], (LogicStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.ATMOST)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			/*if(!child_elms.get(0).getTagName().equals(XMLStructTags.VARIABLE))
				throw new Exception("<Variable> required at first child of <"+tag+">");
			String vtype = child_elms.get(0).getAttribute(XMLStructTags.TYPE);
			if(vtype==null||!vtype.equals(XMLStructTags.DISCOURSE_DOMAIN))
				throw new Exception("<Variable> attribute type need to be <domain>");*/
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			int upper = Integer.parseInt(op.getAttribute(XMLStructTags.UPBOUND));
			
			return LogicFactory.createAtMost((DiscourseDomain)rs[0], (LogicStruct)rs[1], upper);
		}
		else if(tag.equals(XMLStructTags.ATLEAST)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			/*if(!child_elms.get(0).getTagName().equals(XMLStructTags.VARIABLE))
				throw new Exception("<Variable> required at first child of <"+tag+">");
			String vtype = child_elms.get(0).getAttribute(XMLStructTags.TYPE);
			if(vtype==null||!vtype.equals(XMLStructTags.DISCOURSE_DOMAIN))
				throw new Exception("<Variable> attribute type need to be <domain>");*/
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			int lower = Integer.parseInt(op.getAttribute(XMLStructTags.LOWBOUND));
			
			return LogicFactory.createAtLeast((DiscourseDomain)rs[0], (LogicStruct)rs[1], lower);
		}
		else if(tag.equals(XMLStructTags.BETWEEN)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			/*if(!child_elms.get(0).getTagName().equals(XMLStructTags.VARIABLE))
				throw new Exception("<Variable> required at first child of <"+tag+">");
			String vtype = child_elms.get(0).getAttribute(XMLStructTags.TYPE);
			if(vtype==null||!vtype.equals(XMLStructTags.DISCOURSE_DOMAIN))
				throw new Exception("<Variable> attribute type need to be <domain>");*/
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			int lower = Integer.parseInt(op.getAttribute(XMLStructTags.LOWBOUND));
			int upper = Integer.parseInt(op.getAttribute(XMLStructTags.UPBOUND));
			
			return LogicFactory.createBetween((DiscourseDomain)rs[0], (LogicStruct)rs[1], lower,upper);
		}
		else if(tag.equals(XMLStructTags.BIGGER)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return NumericFactory.createBigger((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.EBIGGER)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return NumericFactory.createEBigger((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.EQUAL)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return NumericFactory.createEqual((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.ESMALLER)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return NumericFactory.createESmaller((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.SMALLER)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return NumericFactory.createSmaller((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.CONTAIN)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return GroupFactory.createContain((GroupStruct)rs[0], (GroupStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.INCLUDE)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return GroupFactory.createInclude(rs[0], (GroupStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.GROUP_EQUAL)){
			if(child_elms.size()!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			
			Struct[] rs = this.getChildren(child_elms);
			if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
			
			return GroupFactory.createGroupEqual((GroupStruct)rs[0], (GroupStruct)rs[1]);
		}
		else throw new Exception("Unknown Operator Tag: <"+tag+">");
	}
	
	protected NumericExpression generateNumericExpression(Element op) throws Exception{
		if(op==null)throw new Exception("Null element is invalid");
		
		String tag = op.getTagName();
		
		NodeList children = op.getChildNodes();
		List<Element> child_elms = new ArrayList<Element>();
		
		for(int i=0;i<children.getLength();i++){
			if(children.item(i) instanceof Element){
				child_elms.add((Element) children.item(i));
			}
		}
		
		Struct[] rs = this.getChildren(child_elms);
		if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
		
		if(tag.equals(XMLStructTags.ADD)){
			if(rs.length!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			return NumericFactory.createAddition((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.SUB)){
			if(rs.length!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			return NumericFactory.createSubstract((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.MUL)){
			if(rs.length!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			return NumericFactory.createMultiplication((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.MOD)){
			if(rs.length!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			return NumericFactory.createMod((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.DIV)){
			if(rs.length!=2)throw new Exception("Exactly 2 operands required at: <"+tag+">");
			return NumericFactory.createDivision((NumericStruct)rs[0], (NumericStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.CARDINALITY)){
			if(rs.length!=1)throw new Exception("Exactly 1 operand required at: <"+tag+">");
			return GroupFactory.createCardinality((GroupStruct)rs[0]);
		}
		else throw new Exception("Unknown Numeric Operator tag: <"+tag+">");
	}
	
	protected GroupExpression generateGroupExpression(Element op) throws Exception{
		if(op==null)throw new Exception("Null element is invalid");
		
		String tag = op.getTagName();
		
		NodeList children = op.getChildNodes();
		List<Element> child_elms = new ArrayList<Element>();
		
		for(int i=0;i<children.getLength();i++){
			if(children.item(i) instanceof Element){
				child_elms.add((Element) children.item(i));
			}
		}
		
		Struct[] rs = this.getChildren(child_elms);
		if(rs==null)throw new Exception("Interpretation failed at: <"+tag+">");
		
		if(tag.equals(XMLStructTags.INTERSECTION)){
			if(rs.length<2)throw new Exception("At least 2 children required at <"+tag+">");
			
			GroupStruct[] operands = new GroupStruct[rs.length];
			for(int i=0;i<operands.length;i++)
				operands[i]=(GroupStruct) rs[i];
			
			return GroupFactory.createIntersection(operands);
		}
		else if(tag.equals(XMLStructTags.UNION)){
			if(rs.length<2)throw new Exception("At least 2 children required at <"+tag+">");
			
			GroupStruct[] operands = new GroupStruct[rs.length];
			for(int i=0;i<operands.length;i++)
				operands[i]=(GroupStruct) rs[i];
			
			return GroupFactory.createUnion(operands);
		}
		else if(tag.equals(XMLStructTags.DIFFERENCE)){
			if(rs.length!=2)throw new Exception("Exactly 2 children required at <"+tag+">");
			return GroupFactory.createDifference((GroupStruct)rs[0], (GroupStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.COMPLEMENT)){
			if(rs.length!=1)throw new Exception("Exactly 1 child required at <"+tag+">");
			return GroupFactory.createComplement((GroupStruct)rs[0], (GroupStruct)rs[1]);
		}
		else if(tag.equals(XMLStructTags.CARTESIAN_PRODUCT)){
			if(rs.length<2)throw new Exception("At least 2 children required at <"+tag+">");
			
			GroupStruct[] operands = new GroupStruct[rs.length];
			for(int i=0;i<operands.length;i++)
				operands[i]=(GroupStruct) rs[i];
			
			return GroupFactory.createCartesianProduct(operands);
		}
		else throw new Exception("Unknown GroupOperator tag: <"+tag+">");
	}
	
	protected Struct[] getChildren(List<Element> children)throws Exception{
		if(children==null)throw new Exception("Null children is invalid");
		
		Struct[] rs = new Struct[children.size()];
		
		for(int i=0;i<rs.length;i++){
			XMLInterpreter interpreter = this.container.getInterpreter(children.get(i));
			rs[i] = interpreter.read(children.get(i));
		}
		
		return rs;
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
