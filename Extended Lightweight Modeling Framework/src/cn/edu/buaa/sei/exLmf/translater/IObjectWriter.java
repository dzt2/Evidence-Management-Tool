package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;

public interface IObjectWriter {
	
	public void setResource(File file);
	public void setObjectSpace(IObjectSpace os);
	public boolean validate();
	public void translate() throws Exception;
}
