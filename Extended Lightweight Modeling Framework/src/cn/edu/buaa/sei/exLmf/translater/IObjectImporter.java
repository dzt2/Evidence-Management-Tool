package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public interface IObjectImporter {
	public void setModel(LPackage p);
	public void setResource(File file);
	public boolean validate();
	public IObjectSpace translate() throws Exception;
}
