package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;

public interface IObjectImporter {
	public void setResource(File file);
	public boolean validate();
	public IObjectSpace translate();
}
