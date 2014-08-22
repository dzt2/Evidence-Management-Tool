package cn.edu.buaa.sei.emt.logic.driver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.computer.InferenceMachine;
import cn.edu.buaa.sei.emt.logic.io.AssignerProcesser;
import cn.edu.buaa.sei.emt.logic.io.AssignerTextualAnalyzer;
import cn.edu.buaa.sei.emt.logic.io.LogicSyntaxUnit;
import cn.edu.buaa.sei.emt.logic.io.SyntaxProcesser;
import cn.edu.buaa.sei.emt.logic.io.TextualAnalyzer;
import cn.edu.buaa.sei.emt.logic.io.ValueInterpreter;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;

public class StreamLogicMachine implements LogicDriver, LogicMachine{
	String name;
	TextualAnalyzer def_analyzer;
	SyntaxProcesser def_processer;
	ValueInterpreter interpreter;
	AssignerTextualAnalyzer ass_analyzer;
	AssignerProcesser ass_processer;
	InferenceMachine im;
	InputStream def_in;
	InputStream ass_in;
	
	String def_text;
	String ass_text;
	
	Map<String,Object> variables;
	Map<String,String> assign_map;
	
	
	public StreamLogicMachine(String name){this.name=name;}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Stream-Logic-Machine "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	@SuppressWarnings("deprecation")
	String getText(InputStream in){
		try {
			if(in==null)return null;
			StringBuilder code = new StringBuilder();
			DataInputStream din = new DataInputStream(in);
			
			String line = null;
			while((line=din.readLine())!=null){
				code.append(line).append("\n");
			}
			din.close();
			
			return code.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 *	Getter & Setter
	 */
	public void setName(String name){this.name=name;}
	public String getName(){return this.name;}
	

	/*
	 *	Driver Functions: configuration 
	 */
	@Override
	public void configDefinition(TextualAnalyzer analyzer,
			SyntaxProcesser processer) {
		if(analyzer==null){
			try {
				throw this.getArgException("analyzer", 
						"configDefinition(analyzer,processer)", 
						"Config analyzer of definition failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(processer==null){
			try {
				throw this.getArgException("processer", 
						"configDefinition(analyzer,processer)", 
						"Config processer of definition failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.def_analyzer=analyzer;
		this.def_processer=processer;
	}

	@Override
	public void configValueInterpreter(ValueInterpreter interpreter) {
		// TODO Auto-generated method stub
		if(interpreter==null){
			try {
				throw this.getArgException("interpreter", 
						"configValueInterpreter(interpreter)", 
						"Config ValueInterpreter failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.interpreter=interpreter;
	}

	@Override
	public void configAssigner(AssignerTextualAnalyzer analyzer,
			AssignerProcesser processer) {
		// TODO Auto-generated method stub
		if(analyzer==null){
			try {
				throw this.getArgException("analyzer", 
						"configAssigner(analyzer,processer)", "Config Assigner Analyzer failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(processer==null){
			try {
				throw this.getArgException("processer", 
						"configAssigner(analyzer,processer)", "Config Assigner processer failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.ass_analyzer=analyzer;
		this.ass_processer=processer;
	}

	@Override
	public void configInferencer(InferenceMachine im) {
		// TODO Auto-generated method stub
		if(im==null){
			try {
				throw this.getArgException("im", 
						"configInterencer(im)", "Config InferenceMachine failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.im=im;
	}

	@Override
	public void configDefinitionInput(InputStream in) {
		// TODO Auto-generated method stub
		if(in==null){
			try {
				throw this.getArgException("in", "configDefinitionInput", 
						"Config Definition Input failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.def_in=in;
	}

	@Override
	public void configAssignmentInput(InputStream in) {
		// TODO Auto-generated method stub
		if(in==null){
			try {
				throw this.getArgException("in", "configAssignmentInput(in)", 
						"Config Assignment Input failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.ass_in=in;
	}

	
	/*
	 * Machine Functions: execution
	 * 
	 */
	@Override
	public Boolean init() {
		// TODO Auto-generated method stub
		if(this.def_in==null||this.def_analyzer==null||this.def_processer==null){
			try {
				throw this.getArgException("definition inputstream", 
						"init()", "Definition configured failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(this.ass_in==null||this.ass_analyzer==null||this.ass_processer==null||this.interpreter==null){
			try {
				throw this.getArgException("assignment", "init()", "Assignment config failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(this.im==null){
			try {
				throw this.getArgException("inference", "init()", "InferenceMachine config failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		this.def_text=this.getText(def_in);
		this.ass_text=this.getText(ass_in);
		
		if(def_text==null){
			try {
				throw this.getArgException("definition text", "init()", "definition inputstream reading failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if(ass_text==null){
			try {
				throw this.getArgException("assignment text", "init()", "assignment inputstream reading failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		
		try {
			/*
			 * 	Definition.
			 */
			this.def_analyzer.setText(def_text);
			List<LogicSyntaxUnit> units = this.def_analyzer.analysis();
			this.def_processer.clear();
			this.def_processer.appendUnits(units);
			variables = this.def_processer.compile();
			
			/*
			 *	Assignment 
			 */
			this.ass_analyzer.setText(ass_text);
			assign_map = this.ass_analyzer.compileAssignmentExpressions();
			this.ass_processer.setAssignMap(assign_map);
			this.ass_processer.setSpace(variables);
			this.ass_processer.setValueInterpreter(interpreter);
			
			this.ass_processer.assign();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<String> getVariableNames() {
		// TODO Auto-generated method stub
		if(this.variables==null){
			try {
				throw this.getArgException("variables", "getVariableNames()", "variables are not generated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.variables.keySet();
	}

	@Override
	public Object getVariable(String name) {
		// TODO Auto-generated method stub
		if(this.variables==null){
			try {
				throw this.getArgException("variables", "getVariableNames()", "variables are not generated.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(!this.variables.containsKey(name)){
			try {
				throw this.getArgException(name, "getVariable(name)", name+ " has not been defined in variables");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.variables.get(name);
	}

	@Override
	public Boolean compute(String name) {
		// TODO Auto-generated method stub
		if(!this.init()){
			try {
				throw this.getArgException("initialization", "compute(name)", "Initialization Failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		Object obj = this.getVariable(name);
		if(obj==null||!(obj instanceof LogicFormulation)){
			try {
				throw this.getArgException(name, "compute(name)", 
						"Invalid/Uncomputable variable for inference");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		
		this.im.setFormulation((LogicFormulation) obj);
		return this.im.safeInference();
	}

	
	
}
