package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;
import java.util.List;

import cn.edu.buaa.sei.exLmf.manager.IModelPrinter;
import cn.edu.buaa.sei.exLmf.manager.impl.ModelPrinter;
import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LClassifier;
import cn.edu.buaa.sei.exLmf.metamodel.LEnum;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IModelImporter im = new EcoreModelImporter("IMPORT");
		im.setResource(new File("test.ecore"));
		try {
			LPackage p = im.translate();
			IModelPrinter printer = new ModelPrinter("Printer");
			System.out.println(printer.printLPackage(p));
			
			List<LClassifier> types = p.getTypes();
			for(int i=0;i<types.size();i++){
				if(types.get(i) instanceof LClass)
					System.out.println(printer.printLClass((LClass) types.get(i)));
				else if(types.get(i) instanceof LEnum)
					System.out.println(printer.printLEnum((LEnum) types.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
