package cn.edu.buaa.sei.emt.logic.script;

import java.util.List;

public class ValueAnalyzerImpl implements ValueAnalyzer{
	String name;
	String text;
	
	public ValueAnalyzerImpl(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Value Analyzer "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}

	/*
	 *	Core Functions 
	 */
	@Override
	public void input(String text) throws Exception {
		// TODO Auto-generated method stub
		if(text==null){
			throw this.getArgException("text", "input(text)", "Invalid text: null");
		}
		this.text=text.trim();
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.text;
	}

	@Override
	public Boolean validate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ValueUnit> analyze() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
