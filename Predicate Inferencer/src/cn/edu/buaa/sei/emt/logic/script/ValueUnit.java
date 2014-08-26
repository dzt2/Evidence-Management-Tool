package cn.edu.buaa.sei.emt.logic.script;

public class ValueUnit {
	
	String name;
	//ValueType type;
	String value;
	
	public ValueUnit(String name,String value) throws Exception{
		this.setName(name);
		this.setValue(value);
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Value Unit generation failed.");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	// Getter & Setter
	public String getName(){return this.name;}
	public void setName(String name) throws Exception{
		if(name==null||name.trim().length()<1){
			throw this.getArgException("name", "setName(name)", 
					"null/empty name cannot be used for specifying target variables");
		}
		this.name=name.trim();
	}
	public String getValue(){return this.value;}
	public void setValue(String value) throws Exception{
		if(value==null||value.trim().length()==0)
			throw this.getArgException("type|value", "setValue(type,value)", "null arguments are invalid");
		this.value=value.trim();
	}
	
	public String toString(){return this.name+":="+this.value;}
	
}
