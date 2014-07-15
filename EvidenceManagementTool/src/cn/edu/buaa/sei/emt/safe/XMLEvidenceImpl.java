package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class XMLEvidenceImpl extends ManagedObjectImpl implements XMLEvidence, Evidence {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public XMLEvidenceImpl() {
		super(LMFContext.typeForName(XMLEvidence.TYPE_NAME));
	}
	
	@Override
	public String getName() {
		return get(XMLEvidence.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(XMLEvidence.KEY_NAME, value);
	}
	
	@Override
	public String getXml_url() {
		return get(XMLEvidence.KEY_XML_URL).stringValue();
	}
	
	@Override
	public void setXml_url(String value) {
		set(XMLEvidence.KEY_XML_URL, value);
	}
	
}
