package cn.edu.buaa.sei.emt.logic.script;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public class ValueConstructor {
	private ValueAnalyzer analyzer;
	//private ValueInterpreter interpreter;
	private ValueProcesser processer;
	private InputStream input;
	
	public ValueConstructor(ValueAnalyzer analyzer,ValueProcesser processer){
		this.analyzer=analyzer;this.processer=processer;
	}
	
	/*
	 *	Tool Functions 
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Value Constructor reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	public ValueAnalyzer getAnalyzer() {
		return analyzer;
	}
	public void setAnalyzer(ValueAnalyzer analyzer) {
		this.analyzer = analyzer;
	}
	public ValueProcesser getProcesser() {
		return processer;
	}
	public void setProcesser(ValueProcesser processer) {
		this.processer = processer;
	}
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
	
	/*
	 *	Core Functions 
	 */
	@SuppressWarnings("deprecation")
	public Map<String,Value> compile() throws Exception{
		if(this.analyzer==null||this.input==null||this.processer==null){
			throw this.getArgException("analyzer|interpreter|processer|input", "compile()", "Unready");
		}
		
		StringBuilder text = new StringBuilder();
		DataInputStream in = new DataInputStream(input);
		String line=null;
		
		while((line=in.readLine())!=null)
			text.append(line).append("\n");
		
		this.analyzer.input(text.toString());
		List<ValueUnit> units = this.analyzer.analyze();
		this.processer.clearUnitList();
		this.processer.appendUnitList(units);
		return this.processer.compile();
	}
	
	
	
	
	
	
	
}
