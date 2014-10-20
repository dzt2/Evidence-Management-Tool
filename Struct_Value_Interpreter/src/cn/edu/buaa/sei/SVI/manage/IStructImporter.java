package cn.edu.buaa.sei.SVI.manage;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

/**
 * IStructImporter is an importer for reading Struct from file/xml/database and reconstruct
 * them in the system.
 * */
public interface IStructImporter {
	public void setInput(SVIResource in) throws Exception;
	public Struct read() throws Exception;
}
