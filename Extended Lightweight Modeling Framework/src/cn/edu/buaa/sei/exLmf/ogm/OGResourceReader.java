package cn.edu.buaa.sei.exLmf.ogm;

public interface OGResourceReader {
	public IObjectWorld getCache();
	public void setResource(OGResource resource) throws Exception;
	
	public void read() throws Exception;
	public void link() throws Exception;
}
