package cn.edu.buaa.sei.exLmf.ogm;

import java.io.File;

public interface OG_FileResource extends OGResource{
	public File[] getFileGroup();
	public void setFileGroup(File[] file) throws Exception;
}
