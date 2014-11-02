package cn.edu.buaa.sei.exLmf.ogm;

public interface OGResourceReader {
	public IObjectWorld getCache();
	public void read() throws Exception;
	public void setResource(OGResource resource) throws Exception;
}
