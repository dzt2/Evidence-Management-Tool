package cn.edu.buaa.sei.emt.logic.script;

import java.util.ArrayList;
import java.util.List;

public class DefinitionAnalyzerImpl implements DefinitionAnalyzer{
	/*
	 * Definition Text
	 * 		A: and(B,C,D)
	 * 		B: or(E,F)
	 * 		C: not(G)
	 * 		D: impl(C,E)
	 * 		G: eq(E,F)
	 * 		E: prop
	 * 		F: predicate(x,y)
	 * 		x: var
	 * 		y: Y.iter
	 * 		X: domain
	 * 		Y: domain
	 * 		L: predicate(X.iter,Y.iter)
	 * 		M: all(X,N)
	 * 		N: any(Y,L)
	 */
	String text;
	String name;
	List<String> lines = new ArrayList<String>();
	
	/*
	 *	Words 
	 */
	public static final char SEM = ';';
	public static final char LIN = '\n';
	public static final char CMT = '%';
	public static final char DOT = ',';
	public static final char LEFT = '(';
	public static final char RIGHT = ')';
	public static final char COLON = ':';
	
	public DefinitionAnalyzerImpl(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Definition Analyzer "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	public void setName(String name){this.name=name;}
	public void input(String text) throws Exception{
		if(text==null){
			throw this.getArgException("text", "input(text)", "Invalid input: null");
		}
		this.text=text.trim();
	}
	public String getName(){return this.name;}
	public String getText(){return this.text;}

	/*
	 * 	Core Functions
	 *  --------------------------------------------------------------------
	 *  1)validate()
	 *  	-ex1: null this.text
	 *  	-ex2: null statement generation (line)
	 *  	statement end with '\n' or ';' or '%'
	 *  	comment start with '%' and end with '\n'
	 *  	-ee3: skip all the comments in code
	 *  --------------------------------------------------------------------
	 *  2) generateUnit(stmt)
	 *  	-ex1: null/empty stmt	 --> invalid statement
	 *  	-ex2: !stmt.contain(":") --> no type specified
	 *  	-ex3: stmt.containt('(')&&!stmt.contain(')') --> invalid formation
	 *  	-ex4: stmt --> name : type() ==> name: type
	 *  	-ex5: stmt --> name : type(n1,,n3) ==> null argument[i]
	 *  --------------------------------------------------------------------
	 *  3) analyze()
	 *  	-ex1: validate() failed
	 *  	-ex2: generateUnit(line) failed and return null;
	 */
	@Override
	public Boolean validate() {
		// TODO Auto-generated method stub
		if(text==null){
			try {
				throw this.getArgException("text", "validate()", 
						"null text is invalid to the textual validation.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		char[] strs = text.toCharArray();
		int pre = 0,cur=0;
		Boolean out_comment = true;
		int count = 0;
		for(int i=0;i<strs.length;i++){
			char ch = strs[i];
			if(out_comment){
				if(ch==SEM||ch==LIN||ch==CMT){
					cur=i;
					String stmt = text.substring(pre, cur);
					count++;
					if(stmt==null){
						try {
							throw this.getArgException("line", "validate()", "errors at line: "+count);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return false;
					}
					this.lines.add(stmt.trim());
					pre=i+1;cur=pre;
					if(ch==CMT){
						out_comment=false;
					}
				}
			}
			else{
				if(ch==LIN){
					out_comment=true;
					pre=i+1;
				}
			}
		}
		
		if(pre<text.length())
			this.lines.add(text.substring(pre).trim());
		return true;
	}
	protected List<String> args = new ArrayList<String>();
	@Override
	public List<DefinitionUnit> analyze() throws Exception {
		// TODO Auto-generated method stub
		if(!this.validate()){
			try {
				throw this.getArgException("text", "analysis()", 
						"The generation of lines list failed.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		List<DefinitionUnit> list = new ArrayList<DefinitionUnit>();
		for(int i=0;i<this.lines.size();i++){
			String stmt = lines.get(i);
			if(stmt==null||stmt.trim().length()==0)continue;
			
			DefinitionUnit unit = this.generateUnit(stmt.trim());
			if(unit==null)
				throw this.getArgException("lines["+i+"]", "analysis()", 
						"errors at line: "+lines.get(i));
			list.add(unit);
			
		}
		return list;
	}
	DefinitionUnit generateUnit(String stmt) throws Exception{
		// Null check
				if(stmt==null||stmt.length()==0){
					return null;
				}
				
				// Initialization
				stmt=stmt.trim();
				int per = 0;
				int cur = 0;
				char[] strs = stmt.toCharArray();
				
				String var=null;
				String type = null;
				args.clear();
				
				// getting the name
				for(;cur<strs.length;cur++)
					if(strs[cur]==COLON){
						var = stmt.substring(per, cur);
						cur++;per=cur;
						break;
					}
				if(cur>=strs.length){
					throw this.getArgException("stmt", "generateUnit(stmt)", 
							"No type is specified for statement: "+stmt);
				}
				
				// re-modify
				stmt = stmt.substring(cur).trim();
				per=0;cur=0;
				strs = stmt.toCharArray();
				
				// getting the type
				for(;cur<strs.length;cur++){
					if(strs[cur]==LEFT){
						type=stmt.substring(per, cur);
						cur++;
						break;
					}
				}
				if(cur>=strs.length){
					type=stmt.substring(per);
					return new DefinitionUnit(var.trim(),type.trim(),null);
				}
				
				
				int end = stmt.lastIndexOf(RIGHT);
				if(end<0){
					throw this.getArgException("stmt", "generateUnit(stmt)", 
							"\'"+RIGHT+"\' is required at the end of stmt: "+stmt);
				}
				
				//re-modify
				stmt = stmt.substring(cur,end).trim();
				per=0;cur=0;
				strs = stmt.toCharArray();
				
				
				//getting the args
				for(;cur<strs.length;cur++){
					char ch = strs[cur];
					if(ch==DOT){
						String arg = stmt.substring(per, cur);
						if(arg==null||arg.trim().length()<1)
							throw this.getArgException("stmt.args", "generateUnit(stmt)", 
									"The "+args.size()+"th argument is empty.");
						args.add(arg.trim());
						per=cur+1;
						continue;
					}
				}
				// getting the last arg
				String arg = stmt.substring(per, cur);
				if(arg==null||arg.trim().length()<1)
					throw this.getArgException("stmt.args", "generateUnit(stmt)", 
							"The "+args.size()+"th argument is empty.");
				args.add(arg.trim());
				
				// perpare to return the unit.
				String[] nargs = new String[args.size()];
				for(int i=0;i<args.size();i++)
					nargs[i]=args.get(i).trim();
				return new DefinitionUnit(var.trim(),type.trim(),nargs);
	}
}
