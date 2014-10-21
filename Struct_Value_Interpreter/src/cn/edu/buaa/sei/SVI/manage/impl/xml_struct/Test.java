package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.io.File;
import java.util.Set;

import cn.edu.buaa.sei.SVI.manage.IStructImporter;
import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.manage.impl.SVIFile;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class Test {

	public static void main(String[] args) {
		IStructImporter importer = new XMLStructImporter();
		try {
			importer.setInput(new SVIFile(new File("data/a.xml")));
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

}
