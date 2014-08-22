package cn.edu.buaa.sei.emt.logic.io;

import java.util.HashMap;
import java.util.Map;

public class AssignerTextualAnalyzerImpl implements AssignerTextualAnalyzer{
	public static final String END = "\n";
	public static final String ASSIGN = "=";
	
	String text;
	String name;
	
	public AssignerTextualAnalyzerImpl(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Assigner Textual Analyzer "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Setter Getter 
	 */
	public String getName(){return this.name;}
	@Override
	public void setText(String text) {this.text=text;}
	@Override
	public String getText() {return this.text;}

	/*
	 *	Core Functions 
	 */
	@Override
	public Boolean validate() {
		// TODO Auto-generated method stub
		if(this.text==null){
			try {
				throw this.getArgException("this.text", "validate()", "Null text cannot be analyzed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		String[] sentences = this.text.trim().split("\\"+END);
		if(sentences==null||sentences.length==0){
			try {
				throw this.getArgException("this.text", "validate()", "text must end with \""+END+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
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
				try {
					throw this.getArgException("this.text.sentences["+i+"]", "validate()", 
							"Expression must containt Assignment Operator: "+ASSIGN);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Map<String, String> compileAssignmentExpressions() {
		// TODO Auto-generated method stub
		if(!this.validate()){
			try {
				throw this.getArgException("this.text", "compileAssignmentExpressions()", "validation failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Map<String,String> expressions = new HashMap<String,String>();
		
		String[] sentences = this.text.trim().split("\\"+END);
		for(int i=0;i<sentences.length;i++){
			String stmt = sentences[i];
			if(stmt==null||stmt.trim().length()==0)continue;
			stmt = stmt.trim();
			int k = stmt.indexOf(ASSIGN);
			
			String name = stmt.substring(0, k).trim();
			String value = stmt.substring(k+1).trim();
			
			if(expressions.containsKey(name)){
				try {
					throw this.getArgException("this.text.sentences["+i+"]", 
							"compileAssignmentExpressions()", "name conflict: "+name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
			expressions.put(name, value);
		}
		
		return expressions;
	}
	
}
