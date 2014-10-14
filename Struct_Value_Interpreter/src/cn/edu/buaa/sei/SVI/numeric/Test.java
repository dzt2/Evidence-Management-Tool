package cn.edu.buaa.sei.SVI.numeric;

import cn.edu.buaa.sei.SVI.core.extend.NumericStruct;
import cn.edu.buaa.sei.SVI.core.variable.Variable;
import cn.edu.buaa.sei.SVI.numeric.impl.NumericFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			NumericStruct x = create2();
			System.out.println(x.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static NumericStruct create1() throws Exception{
		NaturalVariable a = NumericFactory.createNaturalVariable("a");
		RationalVariable b = NumericFactory.createRationalVariable("b");
		ZIntegerVariable c = NumericFactory.createZIntegerVariable("c");
		RealVariable d = NumericFactory.createRealVariable("d");
		
		NumericExpression t221 = NumericFactory.createMultiplication(c, d);
		NumericExpression t222 = NumericFactory.createDivision(a, b);
		NumericExpression t22 = NumericFactory.createSubstract(t221, t222);
		NumericExpression t2 = NumericFactory.createAddition(b, t22);
		
		return NumericFactory.createAddition(a, t2);
	}
	
	public static NumericStruct create2() throws Exception{
		RealVariable x = NumericFactory.createRealVariable("x");
		RealVariable y = NumericFactory.createRealVariable("y");
		RealVariable z = NumericFactory.createRealVariable("z");
		
		NumericFunctionTemplate gtemp = NumericFactory.createNaturalFunctionTemplate("g", new Variable[]{x});
		NumericFunction g = NumericFactory.createNumericFunction(gtemp, null, null);
		
		//NumericExpression t1 = NumericFactory.createMultiplication(y, z);
		
		NumericFunctionTemplate ftemp = NumericFactory.createRealFunctionTemplate("f", new Variable[]{y,z});
		//ftemp.assign(new Object[]{t1,x});
		NumericFunction f = NumericFactory.createNumericFunction(ftemp, null, null);
		
		return NumericFactory.createAddition(g, f);
	}
	
	
	
	
	
	
	
}
