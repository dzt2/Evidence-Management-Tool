package cn.edu.buaa.sei.emt.logic.driver;

import java.io.InputStream;

import cn.edu.buaa.sei.emt.logic.computer.InferenceMachine;
import cn.edu.buaa.sei.emt.logic.io.AssignerProcesser;
import cn.edu.buaa.sei.emt.logic.io.AssignerTextualAnalyzer;
import cn.edu.buaa.sei.emt.logic.io.SyntaxProcesser;
import cn.edu.buaa.sei.emt.logic.io.TextualAnalyzer;
import cn.edu.buaa.sei.emt.logic.io.ValueInterpreter;

public interface LogicDriver {
	public void configDefinition(TextualAnalyzer analyzer,SyntaxProcesser processer);
	public void configValueInterpreter(ValueInterpreter interpreter);
	public void configAssigner(AssignerTextualAnalyzer analyzer,AssignerProcesser processer);
	
	public void configInferencer(InferenceMachine im);
	
	public void configDefinitionInput(InputStream in);
	public void configAssignmentInput(InputStream in);
}
