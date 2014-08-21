package cn.edu.buaa.sei.emt.logic.io;

import java.util.List;
import java.util.Map;

public interface SyntaxProcesser {
	public void appendUnits(List<LogicSyntaxUnit> units);
	public void appendUnit(LogicSyntaxUnit unit);
	public LogicSyntaxUnit getUnit(int i);
	public LogicSyntaxUnit removeUnit(int i);
	public int size();
	
	public Map<String,Object> compile();
}
