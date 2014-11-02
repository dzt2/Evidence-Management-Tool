package cn.edu.buaa.sei.exLmf.ogm.impl;

import java.io.File;

import cn.edu.buaa.sei.exLmf.ogm.OG_File;

public class OG_FileResource implements OG_File{
	File file;

	@Override
	public File getFile() {return this.file;}

	@Override
	public void setFile(File file) throws Exception {
		if(file==null)throw new Exception("Null files are invalid");
		this.file = file;
	}
}
