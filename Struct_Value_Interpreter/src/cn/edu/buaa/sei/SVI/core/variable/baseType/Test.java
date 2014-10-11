package cn.edu.buaa.sei.SVI.core.variable.baseType;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void testMap(MapVariable var) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		var.assign(map);
	}
}
