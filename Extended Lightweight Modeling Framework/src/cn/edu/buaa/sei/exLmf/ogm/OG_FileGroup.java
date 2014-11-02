package cn.edu.buaa.sei.exLmf.ogm;

import java.io.File;

public interface OG_FileGroup extends OGResource{
	public File[] getFiles();
	public void setFiles(File[] files)throws Exception;
}
