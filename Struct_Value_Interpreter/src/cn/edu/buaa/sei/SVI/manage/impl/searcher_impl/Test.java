package cn.edu.buaa.sei.SVI.manage.impl.searcher_impl;

import cn.edu.buaa.sei.SVI.manage.IStructSearcher;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;

public class Test {
	public static void main(String[] args) {
		IStructSearcher searcher = new StructSearcher1();
		try {
			Struct base = create1();
			String path = ".op.scope.op.scope.template.arg[2]";
			
			base = searcher.get(base, path);
			
			System.out.println(base.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Struct create1() throws Exception{
		DiscourseDomain HLR = LogicFactory.createDiscourseDomain("HLR");
		DiscourseDomain LLR = LogicFactory.createDiscourseDomain("LLR");
		
		LogicFunctionTemplate template = LogicFactory.createLogicFunctionTemplate(
				"traceable", new Variable[]{HLR.getIterator(),LLR.getIterator()});
		LogicFunction traceable = LogicFactory.createLogicFunction(template);
		
		LogicExpression L = LogicFactory.createExistential(LLR, traceable);
		
		return LogicFactory.createUniversal(HLR, L);
	}

}
