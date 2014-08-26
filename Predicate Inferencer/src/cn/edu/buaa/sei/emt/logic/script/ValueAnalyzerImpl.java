package cn.edu.buaa.sei.emt.logic.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValueAnalyzerImpl implements ValueAnalyzer{
	
	public static final String END = "\n";
	public static final String ASSIGN = "=";
	
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
	public Boolean validate() throws Exception {
		// TODO Auto-generated method stub
		if(this.text==null){
			throw this.getArgException("this.text", "validate()", "Null text cannot be analyzed");
		}
		
		String[] sentences = this.text.trim().split(END);
		if(sentences==null){
			throw this.getArgException("this.text", "validate()", "text must end with \""+END+"\"");
		}
		
		for(int i=0;i<sentences.length;i++){
			String sentence = sentences[i];
			if(sentence==null||sentence.trim().length()==0){
				continue;
				/*try {
					throw this.getArgException("this.text.sentences["+i+"]",
							"validate()", "Empty Sentence.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;*/
			}
			sentence=sentence.trim();
			if(sentence.indexOf(ASSIGN)<0){
				throw this.getArgException("this.text.sentences["+i+"]", "validate()", 
						"Expression must containt Assignment Operator: "+ASSIGN);
			}
		}
		
		return true;
	}
	@Override
	public List<ValueUnit> analyze() throws Exception {
		// TODO Auto-generated method stub
		if(!validate()){
			throw this.getArgException("validation", "analyze()", "validation failed");
		}
		
		Map<String,String> expressions = new HashMap<String,String>();
		
		String[] sentences = this.text.split(END);
		for(int i=0;i<sentences.length;i++){
			String stmt = sentences[i];
			if(stmt==null||stmt.trim().length()==0)continue;
			stmt = stmt.trim();
			int k = stmt.indexOf(ASSIGN);
			
			String name = stmt.substring(0, k);
			String value = stmt.substring(k+1);
			
			if(name==null||value==null){
				throw this.getArgException("this.text.sentences["+i+"]", 
						"analyze()", "Invalid statement: "+stmt);
			}
			
			if(expressions.containsKey(name)){
				try {
					throw this.getArgException("this.text.sentences["+i+"]", 
							"analyze()", "name conflict: "+name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
			
			expressions.put(name.trim(), value.trim());
		}
		
		List<ValueUnit> units = new ArrayList<ValueUnit>();
		
		Set<String> names = expressions.keySet();
		for(String name:names){
			String value = expressions.get(name);
			units.add(new ValueUnit(name,value));
		}
		
		return units;
	}
	
	/*ValueType getType(String stmt){
		// This is only a initial type recognition.
		if(stmt==null||stmt.trim().length()==0)return null;
		
		stmt = stmt.trim();
		
		int s = stmt.indexOf(SET_LEFT);
		int e = stmt.lastIndexOf(SET_RIGHT);
		if(s>=0){
			if(e!=stmt.length()-1){
				try {
					throw this.getArgException("stmt", "getType()", "Invalid statement: "+stmt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			String name = stmt.substring(0, s);
			if(name!=null&&name.trim().equals(RELATION_NAME))
				return ValueType.RelationSet;
			else return ValueType.Set;
		}
		
		s = stmt.indexOf(RELATION_LEFT);
		e = stmt.lastIndexOf(RELATION_RIGHT);
		
		if(s>=0&&e==text.length()-1){return ValueType.Relation;}
		else if(s>=0){
			try {
				throw this.getArgException("stmt", "getType()", "Invalid statement: "+stmt);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		return ValueType.Object;
	}*/
}
