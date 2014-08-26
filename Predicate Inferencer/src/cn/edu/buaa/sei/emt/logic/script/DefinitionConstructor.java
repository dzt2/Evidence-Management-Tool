package cn.edu.buaa.sei.emt.logic.script;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.List;

import cn.edu.buaa.sei.emt.logic.creator.LogicCreator;

public class DefinitionConstructor {
	private DefinitionAnalyzer analyzer;
	private DefinitionProcesser processer;
	private InputStream input;
	
	public DefinitionConstructor(DefinitionAnalyzer analyzer,DefinitionProcesser processer){
		this.setAnalyzer(analyzer);this.setProcesser(processer);
	}

	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Definition Constructor reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	public DefinitionAnalyzer getAnalyzer() {
		return analyzer;
	}
	public void setAnalyzer(DefinitionAnalyzer analyzer) {
		this.analyzer = analyzer;
	}
	public DefinitionProcesser getProcesser() {
		return processer;
	}
	public void setProcesser(DefinitionProcesser processer) {
		this.processer = processer;
	}
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
	
	@SuppressWarnings("deprecation")
	/*
	 * Core Functions
	 */
	LogicCreator compile() throws Exception{
		if(this.analyzer==null||this.processer==null||this.input==null){
			throw this.getArgException("analyzer|processer|inputstream", "compile()", "Unready");
		}
		
		StringBuilder res = new StringBuilder();
		DataInputStream in = new DataInputStream(input);
		String line=null;
		
		while((line=in.readLine())!=null){
			res.append(line).append("\n");
		}
		
		this.analyzer.input(res.toString());
		List<DefinitionUnit> units = this.analyzer.analyze();
		this.processer.clearUnitList();
		this.processer.appendUnitList(units);
		return this.processer.compile();
	}
}
