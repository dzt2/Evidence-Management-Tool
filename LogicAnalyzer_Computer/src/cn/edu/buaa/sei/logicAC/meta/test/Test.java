package cn.edu.buaa.sei.logicAC.meta.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.logicAC.meta.common.context.GeneralParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.context.NormativeParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.context.VariablePool;
import cn.edu.buaa.sei.logicAC.meta.common.impl.context.ContextFactory;
import cn.edu.buaa.sei.logicAC.meta.common.impl.var.base.BaseVariableFactory;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter;
import cn.edu.buaa.sei.logicAC.meta.common.var.Variable;
import cn.edu.buaa.sei.logicAC.meta.common.var.Parameter.ParameterType;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testGeneralParameterList();
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
			res.append(val.getClass().getName()).append("(").append(val.toString()).append(")");
		} catch (Exception e) {
			res.append("null");
		}
		
		return res.toString();
	}

	public static void test_var2() throws Exception{
		Variable var = BaseVariableFactory.createVariable("a", BaseVariableFactory.DYNAMIC);
		System.out.println(printVariable(var));
		var.assign(1);
		System.out.println(printVariable(var));
		var.assign(1L);
		System.out.println(printVariable(var));
		var.assign(1.00f);
		System.out.println(printVariable(var));
		var.assign(100.4423);
		System.out.println(printVariable(var));
		var.assign(var);
		System.out.println(printVariable(var));
	}
	
	public static void test_context1() throws Exception{
		VariablePool pool = ContextFactory.createVariablePool(ContextFactory.ARRY_MODE);
		
		pool.appendVariable(BaseVariableFactory.createVariable("a", BaseVariableFactory.BOOLEAN));
		pool.appendVariable(BaseVariableFactory.createVariable("b", BaseVariableFactory.DATE));
		pool.appendVariable(BaseVariableFactory.createVariable("c", BaseVariableFactory.DOUBLE));
		
		Iterator<Variable> itor = pool.iterator();
		while(itor.hasNext())
			System.out.println(printVariable(itor.next()));
	}

	public static void test_context2() throws Exception{
		RunnerEnvironment env = ContextFactory.createRunnerEnvironment(ContextFactory.ARRY_MODE, null);
		env.appendVariable(BaseVariableFactory.createVariable("a", BaseVariableFactory.BOOLEAN));
		env.appendVariable(BaseVariableFactory.createVariable("b", BaseVariableFactory.DATE));
		env.appendVariable(BaseVariableFactory.createVariable("c", BaseVariableFactory.DOUBLE));
		System.out.println(printEnvironment(env));
		System.out.println("Contain g? "+env.containVariable("g"));
		System.out.println("Contain a? "+env.containVariable("a"));
	}
	public static String printEnvironment(RunnerEnvironment env) throws Exception{
		if(env==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append("Parent: ").append(env.getParentEnvironment()).append("\n");
		code.append("Map{\n");
		
		Set<String> names = env.getEnvNames();
		for(String name:names){
			code.append(name).append("\t --> \t").append(printVariable(env.getVariable(name))).append("\n");
		}
		
		code.append("}");
		return code.toString();
	}

	public static void test_context3() throws Exception{
		NormativeParameterList plist = ContextFactory.createNormParameterList(ContextFactory.ARRY_MODE);
		plist.setOutputParameter(BaseVariableFactory.createVariable("return", BaseVariableFactory.BOOLEAN));
		plist.addArgument(BaseVariableFactory.createVariable("src", BaseVariableFactory.DYNAMIC));
		plist.addArgument(BaseVariableFactory.createVariable("trg", BaseVariableFactory.DYNAMIC));
		System.out.println(printNormativeParameterList(plist));
	}
	public static String printNormativeParameterList(NormativeParameterList plist) throws Exception{
		if(plist==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append(plist.getOutputParameter().getName()).append("\t (");
		
		for(int i=0;i<plist.argumentSize();i++){
			code.append(printVariable(plist.getArgument(i)));
			if(i!=plist.argumentSize()-1)
				code.append(", ");
		}
		
		code.append(")");
		
		return code.toString();
	}
	
	public static void test_environment() throws Exception{
		RunnerEnvironment env = ContextFactory.createRunnerEnvironment(ContextFactory.ARRY_MODE, null);
		Variable a = BaseVariableFactory.createVariable("a", BaseVariableFactory.INTEGER);
		a.assign(15);
		Variable b = BaseVariableFactory.createVariable("b", BaseVariableFactory.FLOAT);
		b.assign(3.1415f);
		Variable c = BaseVariableFactory.createVariable("c", BaseVariableFactory.STRING);
		c.assign("Hello, world.");
		
		env.appendVariable(a);
		env.appendVariable(b);
		env.appendVariable(c);
		env.appendVariable(c);
		
		Set<String> names = env.getEnvNames();
		for(String name:names)
			System.out.println(printVariable(env.getVariable(name)));
		
		env.removeVariable(env.getVariable("c"));
		System.out.println("\n\n");
		names = env.getEnvNames();
		for(String name:names)
			System.out.println(printVariable(env.getVariable(name)));
	}
	
	public static void testGeneralParameterList() throws Exception{
		GeneralParameterList plist = ContextFactory.createGeneralParameterList(ContextFactory.ARRY_MODE);
		
		Parameter a = BaseVariableFactory.createParameter("a", BaseVariableFactory.BOOLEAN, ParameterType.IN);
		Parameter b = BaseVariableFactory.createParameter("b", BaseVariableFactory.INTEGER, ParameterType.OUT);
		Parameter c = BaseVariableFactory.createParameter("c", BaseVariableFactory.FLOAT, ParameterType.IN);
		Parameter d = BaseVariableFactory.createParameter("d", BaseVariableFactory.STRING, ParameterType.IN);
		Parameter e = BaseVariableFactory.createParameter("e", BaseVariableFactory.DATE, ParameterType.OUT);
		a.assign(false);
		b.assign(15);
		c.assign(15.00f);
		d.assign("Hello, world!");
		e.assign(new Date());
		
		plist.addParameter(a);
		plist.addParameter(b);
		plist.addParameter(c);
		plist.addParameter(d);
		plist.addParameter(e);
		
		System.out.println(printGeneralParameterList(plist));
	}
	public static String printGeneralParameterList(GeneralParameterList plist) throws Exception{
		if(plist==null)return null;
		StringBuilder code = new StringBuilder();
		
		List<Parameter> list = plist.getParameters();
		code.append("ALL {\n");
		for(int i=0;i<list.size();i++){
			code.append(printParameter(list.get(i))).append("\n");
		}
		code.append("}\n\n");
		
		list = plist.getInParameters();
		code.append("IN {\n");
		for(int i=0;i<list.size();i++){
			code.append(printParameter(list.get(i))).append("\n");
		}
		code.append("}\n\n");
		
		list = plist.getOutParameters();
		code.append("OUT {\n");
		for(int i=0;i<list.size();i++){
			code.append(printParameter(list.get(i))).append("\n");
		}
		code.append("}\n\n");
		
		return code.toString();
	}
	public static String printParameter(Parameter p){
		if(p==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append(p.getName()).append(":");
		try {
			code.append(p.read().getClass().getName()).append("\t");
		} catch (Exception e) {
			code.append("NULL").append("\t");
		}
		
		code.append("[").append(p.getParameterType()).append("]");
		
		return code.toString();
	}
	
	
	
	
	
	
	
	

}
