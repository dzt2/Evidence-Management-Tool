package cn.edu.buaa.sei.emt.logic.driver;

import java.io.InputStream;
import java.util.Map;

import cn.edu.buaa.sei.emt.logic.creator.LogicCreator;
import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;
import cn.edu.buaa.sei.emt.logic.script.DefinitionAnalyzer;
import cn.edu.buaa.sei.emt.logic.script.DefinitionAnalyzerImpl;
import cn.edu.buaa.sei.emt.logic.script.DefinitionConstructor;
import cn.edu.buaa.sei.emt.logic.script.DefinitionProcesser;
import cn.edu.buaa.sei.emt.logic.script.DefinitionProcesserImpl;
import cn.edu.buaa.sei.emt.logic.script.ValueAnalyzer;
import cn.edu.buaa.sei.emt.logic.script.ValueAnalyzerImpl;
import cn.edu.buaa.sei.emt.logic.script.ValueConstructor;
import cn.edu.buaa.sei.emt.logic.script.ValueInterpreter;
import cn.edu.buaa.sei.emt.logic.script.ValueInterpreterImpl;
import cn.edu.buaa.sei.emt.logic.script.ValueMapper;
import cn.edu.buaa.sei.emt.logic.script.ValueProcesser;
import cn.edu.buaa.sei.emt.logic.script.ValueProcesserImpl;

public class LogicDriver {
	
	Boolean change=false;
	
	private InputStream def_in;
	private InputStream val_in;
	String name;
	DefinitionConstructor def_constructor;
	ValueConstructor val_constructor;
	DefinitionAnalyzer def_analyzer=new DefinitionAnalyzerImpl("DEF_ANALYZER I");
	DefinitionProcesser def_processer=new DefinitionProcesserImpl("DEF_PROCESSER I");
	ValueAnalyzer val_analyzer=new ValueAnalyzerImpl("VAL_ANALYZER I");
	ValueProcesser val_processer;
	ValueInterpreter interpreter;
	ValueMapper mapper = new ValueMapper(null,null);
	
	LogicCreator creator;
	Map<String,Value> map;
	
	public LogicDriver(String name){
		this.name=name;
		interpreter=new ValueInterpreterImpl("INTERPRETER I");
		val_processer=new ValueProcesserImpl("VAL_PROCESSER I",this.interpreter);
		this.def_constructor=new DefinitionConstructor(this.def_analyzer,this.def_processer);
		this.val_constructor=new ValueConstructor(this.val_analyzer,this.val_processer);
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Logical Driver "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}

	/*
	 * Getter & Setter
	 */
	public InputStream getDef_in() {
		return def_in;
	}
	public void setDef_in(InputStream def_in) {
		this.def_in = def_in;
		this.change=true;
	}
	public InputStream getVal_in() {
		return val_in;
	}
	public void setVal_in(InputStream val_in) {
		this.val_in = val_in;
		this.change=true;
	}
	
	//public LogicCreator getCreator(){return creator;}
	//public Map<String,Value> getValueMap(){return this.map;}
	public LogicFormulation getTarget(String name) throws Exception{
		if(this.creator==null){
			throw this.getArgException("creator", "getTarget(name)", "unready");
		}
		
		LogicFormulation form = null;
		if(this.creator.getFormulationNames().contains(name)){
			form = this.creator.getFormulation(name);
		}
		else if(this.creator.getBindableNames().contains(name)){
			Bindable var = this.creator.getBindable(name);
			if(var instanceof LogicFormulation)form=(LogicFormulation) var;
		}
		
		return form;
	}
	
	/*
	 *	Configuration 
	 */
	public void reconfig() throws Exception{
		if(!change)return;
		
		if(this.def_in==null||this.val_in==null)
			throw this.getArgException("def_input|val_input", "reconfig()", "InputStream is not ready");
		
		this.def_constructor.setInput(def_in);
		this.val_constructor.setInput(val_in);
		creator = this.def_constructor.compile();
		map = this.val_constructor.compile();
		
		this.mapper.setCreator(creator);
		this.mapper.setMap(map);
		this.mapper.assign();
		
		this.change=false;
	}
}
