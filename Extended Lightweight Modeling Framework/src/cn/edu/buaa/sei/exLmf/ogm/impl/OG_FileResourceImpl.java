package cn.edu.buaa.sei.exLmf.ogm.impl;

import java.io.File;

import cn.edu.buaa.sei.exLmf.ogm.OG_FileResource;

public class OG_FileResourceImpl implements OG_FileResource{
	
	File[] files;

	@Override
	public File[] getFileGroup() {return this.files;}

	@Override
	public void setFileGroup(File[] files) throws Exception {
		if(files==null)throw new Exception("Null files are invalid");
		this.files = files;
	}

}
