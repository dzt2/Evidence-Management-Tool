package cn.edu.buaa.sei.emt.logic.io;

import java.util.Map;

public interface AssignerProcesser {
	public void setSpace(Map<String,Object> space);
	public void setValueInterpreter(ValueInterpreter interpreter);
	public void setAssignMap(Map<String,String> assign_map);
	
	public Boolean validate();
	public void assign();
}
