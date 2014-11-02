package cn.edu.buaa.sei.exLmf.ogm.impl;

import cn.edu.buaa.sei.exLmf.metamodel.LPackage;
import cn.edu.buaa.sei.exLmf.ogm.IObjectImporter;
import cn.edu.buaa.sei.exLmf.ogm.IObjectWorld;
import cn.edu.buaa.sei.exLmf.ogm.OGResource;

public class ObjectImporter implements IObjectImporter{
	
	OGResource resource;
	LPackage model;

	@Override
	public void setResource(OGResource resource) throws Exception {
		if(resource==null)throw new Exception("Null resource is invalid");
		this.resource = resource;
	}
	@Override
	public OGResource getResource() {return this.resource;}

	@Override
	public IObjectWorld read() throws Exception {
		if(this.resource==null)throw new Exception("Null resource is unreadable...");
		if(this.model==null)throw new Exception("Null template cannot creating IObjectWorld...");
		
		
		
		return null;
	}

	@Override
	public void setModelSpace(LPackage model) throws Exception {
		if(model==null)throw new Exception("Null model is invalid");
		this.model = model;
	}
	@Override
	public LPackage getModelSpace() {
		return this.model;
	}

}
