package cn.edu.buaa.sei.exLmf.ogm;

import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public interface IObjectWorld {
	
	public static final String SPLIT = ".";
	
	public void loadModelSpace(LPackage p) throws Exception;
	public LPackage getModelSpace();
	
	public LClass getModelClass(String path) throws Exception;
	public IObjectGroup getObjectGroup(String path) throws Exception;
	public IObjectGroup getObjectGroup(LClass type) throws Exception;
	public boolean containModelClass(LClass type);
}
