package cn.edu.buaa.sei.emt.logic.script;

import java.util.List;
import java.util.Map;

import cn.edu.buaa.sei.emt.logic.predicate.core.Value;

public interface ValueProcesser {
	public void appendUnit(ValueUnit unit);
	public void appendUnitList(List<ValueUnit> units);
	public ValueUnit getUnit(int i);
	public Boolean removeUnit(int i);
	public int getUnitListSize();
	public void clearUnitList();
	
	public Boolean validate() throws Exception;
	public Map<String,Value> compile() throws Exception;
}
