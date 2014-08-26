package cn.edu.buaa.sei.emt.logic.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public class ValueProcesserImpl implements ValueProcesser{
	String name;
	ValueInterpreter interpreter;
	List<ValueUnit> units = new ArrayList<ValueUnit>();
	
	public ValueProcesserImpl(String name,ValueInterpreter interpreter){
		this.name=name; this.interpreter=interpreter;
	}
	
	/*
	 * Tool Functions
	 */
	Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Value Processer "+name+" reports errors:");
		code.append("\n\tArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\n\tReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Getter & Setter 
	 */
	public String getName(){return name;}
	public void setName(String name){this.name=name;}
	public ValueInterpreter getInterpreter(){return this.interpreter;}
	public void setInterpreter(ValueInterpreter interpreter){this.interpreter=interpreter;}

	@Override
	public void appendUnit(ValueUnit unit) {
		if(unit==null){
			try {
				throw this.getArgException("unit", "appendUnit(unit)", "Null input");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.units.add(unit);
	}
	@Override
	public void appendUnitList(List<ValueUnit> units) {
		if(units==null){
			try {
				throw this.getArgException("units", "appendUnitList(units)", "Null input");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		for(int i=0;i<units.size();i++){
			if(units.get(i)==null)continue;
			else this.units.add(units.get(i));
		}
	}
	@Override
	public ValueUnit getUnit(int i) {
		if(i<0||i>=this.units.size()){
			try {
				throw this.getArgException("i", "getUnit(i)", i+" is out of range: size = "+this.units.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.units.get(i);
	}
	@Override
	public Boolean removeUnit(int i) {
		if(i<0||i>=this.units.size()){
			try {
				throw this.getArgException("i", "removeUnit(i)", i+" is out of range: size = "+this.units.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		this.units.remove(i);
		return true;
	}
	@Override
	public int getUnitListSize() {
		return this.units.size();
	}
	@Override
	public void clearUnitList() {
		this.units.clear();
	}

	/*
	 *	Core Functions 
	 */
	@Override
	public Boolean validate() throws Exception {
		if(this.interpreter==null){
			throw this.getArgException("interpreter", "validate()", "Interpretation is not ready.");
		}
		
		Set<String> names = new HashSet<String>();
		for(int i=0;i<this.units.size();i++){
			ValueUnit unit = this.units.get(i);
			if(unit==null){
				throw this.getArgException("units["+i+"]", "validate()", "Null elements in units");
			}
			String name = unit.getName();
			String value = unit.getValue();
			
			if(name==null||name.trim().length()==0)
				throw this.getArgException("units["+i+"].name", "validate()", "Null name in units[i].name");
			if(value==null||value.trim().length()==0)
				throw this.getArgException("units["+i+"].value", "validate()", "Null name in units[i].value");
			
			if(names.contains(name))
				throw this.getArgException("units["+i+"].name", "validate()", "Name conflict: "+name);
			else names.add(name);
		}
		return true;
	}

	@Override
	public Map<String, Value> compile() throws Exception {
		if(!this.validate()){
			throw this.getArgException("validataion", "compile()", "Validation failed");
		}
		
		Map<String,Value> map = new HashMap<String,Value>();
		for(int i=0;i<this.units.size();i++){
			ValueUnit unit = this.units.get(i);
			String name = unit.getName();
			Value val = this.interpreter.interprete(unit);
			if(val==null){
				throw this.getArgException("units["+i+"]", "compile()", "ValueGeneration failed: "+name);
			}
			map.put(name, val);
		}
		return map;
	}
	
	
	
}
