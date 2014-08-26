package cn.edu.buaa.sei.emt.logic.script;

import java.util.List;

import cn.edu.buaa.sei.emt.logic.creator.LogicCreator;

public interface DefinitionProcesser {
	/*
	 *	appendUnit(unit): add a DefinitionUnit into the end of the list of units
	 *	appendUnitList(units): add a list of units into the end
	 *	clearUnitList(): clear the current unit list.
	 *	getUnitListSize(): return the size of current units 
	 */
	public void appendUnit(DefinitionUnit unit);
	public void appendUnitList(List<DefinitionUnit> units);
	public DefinitionUnit getUnit(int i);
	public Boolean removeUnit(int i);
	public void clearUnitList();
	public int getUnitListSize();
	
	/*
	 * 	Compile the list of definition units and return the space of logic formulation 
	 * 	with generated variables and formulations.
	 */
	public LogicCreator compile() throws Exception;
}
