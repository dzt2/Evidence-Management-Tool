package cn.edu.buaa.sei.emt.logic_form.formulation;

import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;

public class LogicInferencer {
	LogicFormulation formulation;
	VariableAnalyzier analyzer = new VariableAnalyzier();
	
	public LogicInferencer(){}
	
	/*
	 *	Getter & Setter 
	 */
	public LogicFormulation getFormulation(){return this.formulation;}
	public void setFormulation(LogicFormulation form){
		this.formulation=form;
		this.analyzer.setFormulation(this.formulation);
	}

	
	public Set<Bindable> getVariables(){return this.analyzer.getExternalVariables();}
	
	
}
