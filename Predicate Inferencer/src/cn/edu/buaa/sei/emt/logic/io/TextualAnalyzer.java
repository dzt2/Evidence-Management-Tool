package cn.edu.buaa.sei.emt.logic.io;

import java.util.List;

public interface TextualAnalyzer {
	public void setText(String text);
	public String getText();
	public Boolean validate();
	public List<LogicSyntaxUnit> analysis() throws Exception;
}
