package cn.edu.buaa.sei.SVI.manage.impl.searcher_impl;

import cn.edu.buaa.sei.SVI.manage.IStructSearcher;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.expression.BinaryOperator;
import cn.edu.buaa.sei.SVI.struct.core.expression.Expression;
import cn.edu.buaa.sei.SVI.struct.core.expression.FlexibleOperator;
import cn.edu.buaa.sei.SVI.struct.core.expression.MultipleOperator;
import cn.edu.buaa.sei.SVI.struct.core.expression.Operator;
import cn.edu.buaa.sei.SVI.struct.core.expression.UnaryOperator;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.function.FunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.group.Complement;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.QuantifierOperator;

public class StructSearcher1 implements IStructSearcher{
	@Override
	public Struct get(Struct base, String path) throws Exception {
		if(base==null||path==null)throw new Exception("Null base|path is invalid");
		
		if(path.trim().length()==0)return base;
		
		String[] paths = path.split("\\.");
		int i=1;
		
		while(base!=null&&i<paths.length){
			base = this.nextOne(base, paths[i++].trim());
		}
		
		if(i<paths.length){
			StringBuilder left = new StringBuilder();
			while(i<paths.length)
				left.append(".").append(paths[i++]);
			System.err.println("Out of range in path: "+left.toString());
		}
		
		return base;
	}
	
	protected Struct next(Variable variable,String name) throws Exception{
		if(variable==null||name==null)throw new Exception("Null variable is invalid");
		
		if(name.length()==0)return null;
		else if((variable instanceof DiscourseDomain)&&name.equals(PathLib.ITERATOR)){
			return ((DiscourseDomain)variable).getIterator();
		}
		else throw new Exception("Invalid match: {"+name+"} at "+variable.getClass().getCanonicalName());
	}
	protected Struct next(Expression expr,String name) throws Exception{
		if(expr==null||name==null)throw new Exception("Null expression is invalid");
		
		if(name.equals(PathLib.OPERATOR))return expr.getOperator();
		else throw new Exception("Invalid match: {"+name+"} at "+expr.getClass().getCanonicalName());
	}
	protected Struct next(Operator op,String name) throws Exception{
		if(op==null||name==null)throw new Exception("Null op is invalid");
		
		name = name.trim();
		if(op instanceof UnaryOperator){
			if(name.equals(PathLib.OPERAND))return ((UnaryOperator) op).getOperand();
			else if(name.startsWith(PathLib.OPERANDS)){
				String i = name.substring(4, name.length()-1);
				if(i==null)throw new Exception("Invalid name in operands: "+name);
				Integer id = Integer.parseInt(i);
				
				if(id<0||id>=1)throw new Exception("Out of range: at "+id+" {[0,+"+1+")}");
				return ((UnaryOperator) op).getOperand();
			}
			else if(op instanceof Complement){
				if(name.equals(PathLib.COMPLEMENT_DOMAIN))return ((Complement) op).getDomain();
			}
			else throw new Exception("Invalid match: {"+name+"} at "+op.getClass().getCanonicalName());
		}
		else if(op instanceof BinaryOperator){
			if(name.equals(PathLib.LEFT_OPERAND))return ((BinaryOperator) op).getLeftOperand();
			else if(name.equals(PathLib.RIGHT_OPERAND))return ((BinaryOperator) op).getRightOperand();
			else if(name.startsWith(PathLib.OPERANDS)){
				String i = name.substring(4, name.length()-1);
				if(i==null)throw new Exception("Invalid name in operands: "+name);
				Integer id = Integer.parseInt(i);
				
				if(id<0||id>=2)throw new Exception("Out of range: at "+id+" {[0,+"+2+")}");
				
				if(id==1)return ((BinaryOperator) op).getLeftOperand();
				else return ((BinaryOperator) op).getRightOperand();
			}
			else if(op instanceof QuantifierOperator){
				if(name.equals(PathLib.DISCOURSE_DOMAIN))return ((QuantifierOperator) op).getDomain();
				else if(name.equals(PathLib.SCOPE))return ((QuantifierOperator) op).getScope();
				else throw new Exception("Invalid match: {"+name+"} at "+op.getClass().getCanonicalName());
			}
			else throw new Exception("Invalid match: {"+name+"} at "+op.getClass().getCanonicalName());
		}
		else if(op instanceof MultipleOperator){
			if(name.startsWith(PathLib.OPERANDS)){
				String i = name.substring(4, name.length()-1);
				if(i==null)throw new Exception("Invalid name in operands: "+name);
				Integer id = Integer.parseInt(i);
				int n = ((MultipleOperator) op).getDimension();
				
				if(id<0||id>=n)throw new Exception("Out of range: at "+id+" {[0,+"+n+")}");
				
				return ((MultipleOperator) op).getOperands()[id];
			}
			else throw new Exception("Invalid match: {"+name+"} at "+op.getClass().getCanonicalName());
		}
		else if(op instanceof FlexibleOperator){
			if(name.startsWith(PathLib.OPERANDS)){
				String i = name.substring(4, name.length()-1);
				if(i==null)throw new Exception("Invalid name in operands: "+name);
				Integer id = Integer.parseInt(i);
				int n = ((FlexibleOperator) op).getOperands().length;
				
				if(id<0||id>=n)throw new Exception("Out of range: at "+id+" {[0,+"+n+")}");
				
				return ((FlexibleOperator) op).getOperands()[id];
			}
			else throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
		}
		
		throw new Exception("Unknown operator type: "+op.getClass().getCanonicalName());
	}
	protected Struct next(Function function,String name) throws Exception{
		if(function==null||name==null)throw new Exception("Null function|name is invalid");
		
		if(name.equals(PathLib.TEMPLATE))return function.getTemplate();
		else if(name.equals(PathLib.BODY))return function.getBody();
		else if(name.equals(PathLib.CONTEXT))return function.getContext();
		else throw new Exception("Unknown operator type: "+function.getClass().getCanonicalName());
	}
	protected Struct next(FunctionTemplate template,String name) throws Exception{
		if(template==null||name==null)throw new Exception("Null function template|name is invalid");
		
		if(name.startsWith(PathLib.ARGUMENT)){
			String i = name.substring(4, name.length()-1);
			if(i==null)throw new Exception("Invalid name in operands: "+name);
			Integer id = Integer.parseInt(i);
			int n = template.getArguments().length;
			
			if(id<0||id>=n)throw new Exception("Out of range: at "+id+" {[0,+"+n+")}");
			
			return template.getArguments()[id];
		}
		else if(name.equals(PathLib.OUTPUT))return template.getOutput();
		else throw new Exception("Unknown operator type: "+template.getClass().getCanonicalName());
	}
	protected Struct nextOne(Struct base,String name) throws Exception{
		if(base==null||name==null)throw new Exception("Null base|name is invalid");
		
		if(base instanceof Variable){
			Variable variable = (Variable) base;
			return this.next(variable, name);
		}
		else if(base instanceof Expression){
			Expression expr = (Expression) base;
			return this.next(expr, name);
		}
		else if(base instanceof Function){
			Function function = (Function) base;
			return this.next(function, name);
		}
		else if(base instanceof Operator){
			Operator op = (Operator) base;
			return this.next(op, name);
		}
		else if(base instanceof FunctionTemplate){
			FunctionTemplate template = (FunctionTemplate) base;
			return this.next(template, name);
		}
		else throw new Exception("Unknown type: "+base.getClass().getCanonicalName());
	}
}
