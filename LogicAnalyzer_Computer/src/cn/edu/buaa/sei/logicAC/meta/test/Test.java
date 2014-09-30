package cn.edu.buaa.sei.logicAC.meta.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.impl.var.base.BaseVariableFactory;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test_var2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test_var1() throws Exception{
		Variable a = BaseVariableFactory.createVariable("a", BaseVariableFactory.BOOLEAN);
		Variable b = BaseVariableFactory.createVariable("b", BaseVariableFactory.CHARACTER);
		Variable c = BaseVariableFactory.createVariable("c", BaseVariableFactory.INTEGER);
		Variable d = BaseVariableFactory.createVariable("d", BaseVariableFactory.LONG);
		Variable e = BaseVariableFactory.createVariable("e", BaseVariableFactory.LIST);
		Variable f = BaseVariableFactory.createVariable("f", BaseVariableFactory.FLOAT);
		Variable g = BaseVariableFactory.createVariable("g", BaseVariableFactory.DOUBLE);
		Variable h = BaseVariableFactory.createVariable("h", BaseVariableFactory.SET);
		Variable i = BaseVariableFactory.createVariable("i", BaseVariableFactory.MAP);
		
		a.assign(true);
		b.assign('c');
		c.assign(1000);
		d.assign(100L);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);
		e.assign(list);
		f.assign(12.56f);
		g.assign(1003.3523);
		Set<Integer> set = new HashSet<Integer>();
		set.add(10);set.add(11);set.add(15);
		h.assign(set);
		i.assign(new HashMap<String,Object>());
		@SuppressWarnings("unchecked")
		Map<String,Object> val = (Map<String, Object>) i.read();
		val.put("a", a.read());
		val.put("b", b.read());
		val.put("c", c.read());
		val.put("d", d.read());
		            
		
		System.out.println(printVariable(a));
		System.out.println(printVariable(b));
		System.out.println(printVariable(c));
		System.out.println(printVariable(d));
		System.out.println(printVariable(e));
		System.out.println(printVariable(f));
		System.out.println(printVariable(g));
		System.out.println(printVariable(h));
		System.out.println(printVariable(i));
		
		System.out.println(a.getName()+":"+a.read().toString());
		System.out.println(b.getName()+":"+b.read().toString());
		System.out.println(c.getName()+":"+c.read().toString());
		System.out.println(d.getName()+":"+d.read().toString());
		System.out.println(e.getName()+":"+e.read().toString());
		System.out.println(f.getName()+":"+f.read().toString());
		System.out.println(g.getName()+":"+g.read().toString());
		System.out.println(h.getName()+":"+h.read().toString());
		System.out.println(i.getName()+":"+i.read().toString());
		
		
	}
	
	public static String printVariable(Variable var){
		if(var==null)return null;
		StringBuilder res = new StringBuilder();
		
		res.append(var.getName()).append(":");
		try {
			Object val = var.read();
			res.append(val.getClass().getName());
		} catch (Exception e) {
			res.append("null");
		}
		
		return res.toString();
	}

	public static void test_var2() throws Exception{
		Variable var = BaseVariableFactory.createVariable("a", BaseVariableFactory.DYNAMIC);
		var.assign(1);
		var.assign(1L);
		var.assign(1.00f);
		var.assign(100.4423);
		var.assign(var);
	}
	
}
