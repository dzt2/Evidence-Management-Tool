package cn.edu.buaa.sei.emt.logic.io;

import java.util.Map;

public interface AssignerTextualAnalyzer {
	public void setText(String text);
	public String getText();
	
	
	//public void setValueInterpreter(ValueInterpreter interpreter);
	//public ValueInterpreter getValueInterpreter();
	
	public Boolean validate();
	public Map<String,String> compileAssignmentExpressions();
}
