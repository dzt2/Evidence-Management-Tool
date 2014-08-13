package cn.edu.buaa.sei.emt.logic.io;

import java.io.File;

import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;

public class XMLLogicIO implements LogicIO{
	File file;
	
	public XMLLogicIO(String file_name){this.file=new File(file_name);}
	public XMLLogicIO(File file){this.file=file;}
	
	public File getFile(){return this.file;}
	public void setFile(File file){this.file=file;}
	
	
	/*
	 *	Core Functions 
	 */
	@Override
	public void write(LogicFormulation form) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LogicFormulation read() {
		// TODO Auto-generated method stub
		return null;
	}
}
