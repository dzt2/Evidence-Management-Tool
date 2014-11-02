package cn.edu.buaa.sei.exLmf.ogm;

public interface IObjectImporter {
	public void setResource(OGResource resource) throws Exception;
	public OGResource getResource();
	
	public IObjectGroup get() throws Exception;
}
