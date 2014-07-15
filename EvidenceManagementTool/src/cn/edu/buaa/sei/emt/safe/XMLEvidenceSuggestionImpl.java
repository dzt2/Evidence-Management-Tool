package cn.edu.buaa.sei.emt.safe;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class XMLEvidenceSuggestionImpl extends ManagedObjectImpl implements XMLEvidenceSuggestion, EvidenceSuggestion {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public XMLEvidenceSuggestionImpl() {
		super(LMFContext.typeForName(XMLEvidenceSuggestion.TYPE_NAME));
	}
	
	@Override
	public String getSchema_url() {
		return get(XMLEvidenceSuggestion.KEY_SCHEMA_URL).stringValue();
	}
	
	@Override
	public void setSchema_url(String value) {
		set(XMLEvidenceSuggestion.KEY_SCHEMA_URL, value);
	}
	
	@Override
	public String getName() {
		return get(XMLEvidenceSuggestion.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(XMLEvidenceSuggestion.KEY_NAME, value);
	}
	
}
