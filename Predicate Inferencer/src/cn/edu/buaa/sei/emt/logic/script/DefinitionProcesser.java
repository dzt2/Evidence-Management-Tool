package cn.edu.buaa.sei.emt.logic.script;

import java.util.List;

import cn.edu.buaa.sei.emt.logic.creator.LogicCreator;

public interface DefinitionProcesser {
	public void appendUnit(DefinitionUnit unit);
	public void appendUnitList(List<DefinitionUnit> units);
	public DefinitionUnit getUnit(int i);
	public Boolean removeUnit(int i);
	public void clearUnitList();
	public int getUnitListSize();
	
	public LogicCreator compile() throws Exception;
}
