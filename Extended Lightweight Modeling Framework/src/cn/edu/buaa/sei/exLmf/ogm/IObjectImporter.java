package cn.edu.buaa.sei.exLmf.ogm;

import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public interface IObjectImporter {
	public void setResource(OGResource resource) throws Exception;
	public OGResource getResource();
	
	public IObjectWorld read() throws Exception;
	
	public void setModelSpace(LPackage model) throws Exception;
	public LPackage getModelSpace();
}
