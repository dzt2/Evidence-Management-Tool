package cn.edu.buaa.sei.SVI.core.variable.impl;

import cn.edu.buaa.sei.SVI.core.variable.ReferenceVariable;
import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.BooleanVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.CharacterVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.DoubleVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.FloatVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.IntegerVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.LongVariable;
import cn.edu.buaa.sei.SVI.core.variable.baseType.StringVariable;

public class Test {

	public static void main(String[] args) {
		try {
			test2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testBoolean() throws Exception{
		BooleanVariable a = VariableFactory.createBoolean("a");
		BooleanVariable b = (BooleanVariable) VariableFactory.createVariable("b", VariableFactory.BOOLEAN);
		
		System.out.println("a: "+a.read());
		System.out.println("b: "+b.read());
		
		a.assign(null);
		a.assign(true);
		b.assign(false);
		
		System.out.println("a: "+a.read());
		System.out.println("b: "+b.read());
		
		ReferenceVariable c = VariableFactory.createReference("c");
		c.refer(a);
		c.assign(false);
		System.out.println("c: "+c.read());
		c.assign(null);
		System.out.println("a: "+a.read());
		System.out.println("b: "+b.read());
		
	}
	public static void testInt() throws Exception{
		IntegerVariable x = VariableFactory.createInteger("x");
		IntegerVariable y = VariableFactory.createInteger("y");
		
		ReferenceVariable z = (ReferenceVariable) VariableFactory.createVariable("z", VariableFactory.REFER);
		z.refer(x);
		
		z.assign(115);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println(printVariable(z));
		System.out.println();
		
		y.assign(-20);
		x.assign(65);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println(printVariable(z));
		System.out.println();
	}
	public static void testChar() throws Exception{
		CharacterVariable x = VariableFactory.createCharacter("x");
		CharacterVariable y = (CharacterVariable) VariableFactory.createVariable("y", VariableFactory.CHARACTER);
		ReferenceVariable z = VariableFactory.createReference("z");
		z.refer(y);
		
		x.assign('a');
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println(printVariable(z));
		System.out.println();
		
		z.assign('b');
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println(printVariable(z));
		System.out.println();
		
		x.assign('d');
		y.assign('c');
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println(printVariable(z));
		System.out.println();
	}

	public static void testString() throws Exception{
		StringVariable x = VariableFactory.createString("x");
		StringVariable y = (StringVariable) VariableFactory.createVariable("y", VariableFactory.STRING);
		
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		x.assign("Hello, X");
		y.assign("Hello, y");
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		x.assign(null);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
	}
	public static void testFloat() throws Exception{
		FloatVariable x = VariableFactory.createFloat("x");
		FloatVariable y = VariableFactory.createFloat("y");
		
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		x.assign(1.5f);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		y.assign(6.45);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
	}
	public static void testDouble() throws Exception{
		DoubleVariable x = VariableFactory.createDouble("x");
		DoubleVariable y = VariableFactory.createDouble("y");
		
		x.assign(12.65);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		y.assign(5.54f);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
	}
	public static void test1() throws Exception{
		FloatVariable x = VariableFactory.createFloat("x");
		DoubleVariable y = VariableFactory.createDouble("y");
		
		x.assign(1.2f);
		y.assign(65.245);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		float qx = x.read();
		double qy = qx;
		y.assign(qy);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
	}
	public static void test2() throws Exception {
		IntegerVariable x = VariableFactory.createInteger("x");
		LongVariable y = VariableFactory.createLong("y");
		
		x.assign(25);
		y.assign(10L);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
		
		int qx = x.read();
		long qy = qx;
		y.assign(qy);
		System.out.println(printVariable(x));
		System.out.println(printVariable(y));
		System.out.println();
	}
	
	static String printVariable(Variable x) throws Exception{
		if(x==null)return null;
		else return x.getName()+": "+x.read();
	}
	
}
