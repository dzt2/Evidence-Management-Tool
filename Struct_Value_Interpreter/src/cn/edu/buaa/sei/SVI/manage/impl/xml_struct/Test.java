package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;

import cn.edu.buaa.sei.SVI.manage.IStructImporter;
import cn.edu.buaa.sei.SVI.manage.IStructPrinter;
import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.manage.impl.SVIStream;
import cn.edu.buaa.sei.SVI.manage.impl.StructManagerImpl;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.logic.DiscourseDomain;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;

public class Test {

	public static void main(String[] args) {
		test2("data/b.xml");
	}
	
	public static void test1(String file){
		IStructImporter importer = new XMLStructImporter();
		try {
			SVIStream in = new SVIStream();
			in.setInputStream(new FileInputStream(new File(file)));
			importer.setInput(in);
			StructManager manager = importer.read();
			
			Set<String> ids = manager.getAllIDs();
			for(String id:ids){
				System.out.println("==============================");
				Struct val = manager.get(id);
				System.out.println(id+": "+val.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test2(String file){
		try {
			Struct s = create1();
			System.out.println(s.toString());
			
			SVIStream out = new SVIStream();
			out.setOutputStream(new FileOutputStream(new File(file)));
			
			IStructPrinter printer = new XMLStructPrinterImpl();
			printer.setOutputStream(out);
			
			StructManager manager = new StructManagerImpl();
			manager.put("1", s);
			printer.write(manager);
			
			System.out.println("Writting Successfully!");
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
