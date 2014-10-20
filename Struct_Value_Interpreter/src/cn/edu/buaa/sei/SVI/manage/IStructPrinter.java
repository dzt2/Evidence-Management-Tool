package cn.edu.buaa.sei.SVI.manage;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

/**
 * IStructPrinter is an outputer which output the Struct to store them in the file/xml/database.
 * */
public interface IStructPrinter {
	public void setOutputStream(SVIResource out) throws Exception;
	public void write(Struct struct) throws Exception;
}
