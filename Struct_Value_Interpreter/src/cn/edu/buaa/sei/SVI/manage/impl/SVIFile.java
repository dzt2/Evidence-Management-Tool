package cn.edu.buaa.sei.SVI.manage.impl;

import java.io.File;

import cn.edu.buaa.sei.SVI.manage.SVIResource;

public class SVIFile implements SVIResource{
	File file;
	
	public SVIFile(File file){this.file=file;}
	
	public File getFile(){return this.file;}
}
