package cn.edu.buaa.sei.emt.logic.script;

import java.util.List;


public interface DefinitionAnalyzer {
	/*
	 *	Definition Analyzer analyzes the text of definition file.
	 *	1) input(text): input text for analysis
	 *	2) getText(): return the current text of definition that has been input.
	 *	3) validate(): validate the format and reports the potential original errors.
	 *	4) analyze(): analyze the input text and return a list of Definition units 
	 *			-variable name
	 *			-type: <LogicExpression,Quantification,Proposition,Predicate>
	 *			-arguments 
	 * 
	 */
	public void input(String text) throws Exception;
	public String getText();
	public Boolean validate();
	public List<DefinitionUnit> analyze() throws Exception;
}
