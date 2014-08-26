package cn.edu.buaa.sei.emt.logic.script;

import java.util.List;

public interface ValueAnalyzer {
	public void input(String text) throws Exception;
	public String getText();
	public Boolean validate() throws Exception;
	public List<ValueUnit> analyze() throws Exception;
}
