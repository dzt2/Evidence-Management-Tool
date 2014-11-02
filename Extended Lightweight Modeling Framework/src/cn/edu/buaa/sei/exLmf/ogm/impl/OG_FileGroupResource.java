package cn.edu.buaa.sei.exLmf.ogm.impl;

import java.io.File;

import cn.edu.buaa.sei.exLmf.ogm.OG_FileGroup;

public class OG_FileGroupResource implements OG_FileGroup{
	File[] files;
	@Override
	public File[] getFiles() {return this.files;}
	@Override
	public void setFiles(File[] files) throws Exception {
		if(files==null)throw new Exception("Null files is invalid");
		this.files = files;
	}
}
