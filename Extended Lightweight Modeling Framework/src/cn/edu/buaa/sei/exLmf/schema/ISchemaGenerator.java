package cn.edu.buaa.sei.exLmf.schema;

import java.io.OutputStream;

import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public interface ISchemaGenerator {
	public void setModel(LPackage p);
	public void setOPipe(OutputStream out);
	public void validate();
	public void generateSchema();
}
