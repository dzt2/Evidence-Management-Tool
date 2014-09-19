package cn.edu.buaa.sei.emt.logic.script;

public class DefinitionUnit {
	/*
	 *	-var: variable name
	 *	-type: type name [in type value set]
	 *	-args: list of names for other variables 
	 */
	String var;
	String type;
	String[] args;
	
	/*
	 *	type value set 
	 */
	public static final String AND = "and";
	public static final String OR = "or";
	public static final String NOT = "not";
	public static final String IMPL = "impl";
	public static final String EQ = "eq";
	public static final String ALL = "all";
	public static final String ANY = "any";
	public static final String VAR = "var";
	public static final String PROP = "prop";
	public static final String PRED = "predicate";
	public static final String DOMAIN = "domain";
	public static final String ITER = ".iter";
	
	
	public DefinitionUnit(String var,String type,String[] args) throws Exception{
		this.setVar(var);
		this.setType(type);
		this.setArgs(args);
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Accessor found errors: ");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Setter 
	 *	------------------------------------------------------------------------
	 *	1. var: variable name
	 *		-match: ([a-z][A-Z])+
	 *		examples: a, A, Pop, stmt
	 *		fault: _a, A1, #Q
	 *	------------------------------------------------------------------------
	 *	2. type: type name
	 *		-match: in (and,or,not,impl,eq,all,any,prop,predicate,var,domain)
	 *	------------------------------------------------------------------------
	 *	3. args: arguments names
	 *		-match:
	 *			[and|or]: 	args.length>=2
	 *			[not]: 		args.length==1
	 *			[impl|eq]:	args.length==2
	 *			[any|all]:	args.length==2
	 *			[prop|var]:	args == null
	 *			[predicate]:args.length>=1
	 *			[domain]:	args == null
	 *	------------------------------------------------------------------------
	 *
	 */
	void setVar(String var) throws Exception{
		if(var==null||var.length()==0){
			throw this.getArgException("var", "setVar(var)", 
					"empty string cannot be used in variable definition name.");
		}
		if(var.matches("([a-z]|[A-Z])([a-z]|[A-Z]|[0-9])*"))
			this.var=var;
		else{
			throw this.getArgException("var", "setVar(var)", 
					"\""+var+"\" is an invalid name for definition.");
		}
	}
	void setType(String type) throws Exception{
		if(type==null||type.length()==0)
			throw this.getArgException("type", "setType(type)", "No type is defined.");
		
		switch(type){
		case AND:break;
		case OR: break;
		case NOT:break;
		case IMPL: break;
		case EQ: break;
		case ALL:break;
		case ANY:break;
		case VAR:break;
		case PROP: break;
		case PRED: break;
		case DOMAIN:break;
		default: throw this.getArgException("type", "setType(type)", 
				"\""+type+"\" is an invalid type name.");
		}
		
		this.type=type;
	}
	void setArgs(String[] args) throws Exception{
		switch(this.type){
		case AND: this.setAnd(args); break;
		case OR:  this.setOr(args); break;
		case NOT: this.setNot(args);break;
		case IMPL:this.setImpl(args);break;
		case EQ:  this.setEq(args);break;
		case ALL: this.setAll(args);break;
		case ANY: this.setAny(args);break;
		case VAR: this.setVar(args);break;
		case PROP:this.setProp(args);break;
		case PRED:this.setPred(args);break;
		case DOMAIN:this.setDomain(args);break;
		default: throw this.getArgException("type", "setArgs(args)", 
				"\""+type+"\" Invalid type cannot be assigned with arguments.");
		}
		
		this.args=args;
	}
	
	void setAnd(String[] args) throws Exception{
		if(args==null||args.length<2){
			throw this.getArgException("args", "setAnd(args)", 
					"at least 2 elements are needed in Conjunction Operator \"and\"");
		}
		this.args=args;
	}
	void setOr(String[] args) throws Exception{
		if(args==null||args.length<2){
			throw this.getArgException("args", "setOr(args)", 
					"at least 2 elements are needed in Conjunction Operator \"or\"");
		}
		this.args=args;
	}
	void setNot(String[] args) throws Exception{
		if(args==null||args.length!=1){
			throw this.getArgException("args", "setNot(args)", 
					"one and only one element is needed in Negation Operator \"not\"");
		}
		this.args=args;
	}
	void setImpl(String[] args) throws Exception{
		if(args==null||args.length!=2){
			throw this.getArgException("args", "setImpl(args)", 
					"one and only two elements are needed in Implication Operator \"impl\"");
		}
		this.args=args;
	}
	void setEq(String[] args) throws Exception{
		if(args==null||args.length!=2){
			throw this.getArgException("args", "setEq(args)", 
					"one and only two elements are needed in Equivalence Operator \"eq\"");
		}
		this.args=args;
	}
	void setAll(String[] args) throws Exception{
		if(args==null||args.length!=2){
			throw this.getArgException("args", "setAll(args)", 
					"one and only two elements are needed in Universal Operator \"all\"");
		}
		this.args=args;
	}
	void setAny(String[] args) throws Exception{
		if(args==null||args.length!=2){
			throw this.getArgException("args", "setAny(args)", 
					"one and only two elements are needed in Existential Operator \"any\"");
		}
		this.args=args;
	}
	void setVar(String[] args) throws Exception{
		if(args!=null)
			throw this.getArgException("args", "setVar(args)", 
					"no arguments are needed for variable type \"var\"");
		this.args=args;
	}
	void setProp(String[] args) throws Exception{
		this.setVar(args);
	}
	void setPred(String[] args) throws Exception{
		if(args==null||args.length<1)
			throw this.getArgException("args", "setPred(arg)", 
					"at least one argument is needed in predicate \"predicate\"");
		this.args=args;
	}
	void setDomain(String[] args) throws Exception{
		if(args!=null)
			throw this.getArgException("args", "setDomain(args)", 
					"no arguments are needed for domain type \"domain\"");
		this.args=args;
	}
	
	/*
	 *	Getter 
	 */
	public String getVar(){return this.var;}
	public String getType(){return this.type;}
	public String[] getArgs(){return this.args;}
	
	/*
	 * Printer
	 */
	public String toString(){
		StringBuilder res = new StringBuilder();
		
		res.append("[var: ").append(var).append(",").append("type: ").append(type).append(",").append("args: (");
		
		if(args==null)
			res.append("null");
		else{
			for(int i=0;i<args.length;i++){
				res.append(args[i]);
				if(i!=args.length-1)res.append(",");
			}
		}
		
		res.append(")").append("]");
		
		return res.toString();
	}
}
