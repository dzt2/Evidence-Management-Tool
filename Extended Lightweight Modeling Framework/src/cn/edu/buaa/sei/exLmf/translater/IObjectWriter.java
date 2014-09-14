package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;

public interface IObjectWriter {
	
	public static String ROOT = "OSpace";
	public static String _ID = "_id";
	public static String TRUE = "true";
	public static String FALSE = "false";
	public static String NULL = "null";
	public static String LIST = "__list";
	public static String ITEM = "__item";
	public static String NAME = "name";
	
	public void setResource(File file);
	public void setObjectSpace(IObjectSpace os);
	public boolean validate();
	public void translate() throws Exception;
}
