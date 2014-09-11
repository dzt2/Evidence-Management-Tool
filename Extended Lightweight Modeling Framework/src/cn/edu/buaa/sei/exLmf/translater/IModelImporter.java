package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;

import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public interface IModelImporter {
	public void setResource(File file);
	public boolean validate() throws Exception;
	public LPackage translate() throws Exception;
}
