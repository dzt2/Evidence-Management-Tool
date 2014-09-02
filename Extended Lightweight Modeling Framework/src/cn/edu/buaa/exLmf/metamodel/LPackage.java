package cn.edu.buaa.exLmf.metamodel;

import java.util.List;

public interface LPackage extends LNamedElement{
	public List<LPackage> getSubPackages();
	public void addSubPackage(LPackage pack);
	public void removeSubPackage(LPackage pack);
	public LPackage getSubPackageByName(String name);
	
	public String getNsURI();
	public void setNsURI(String nsUri);
	public String getNsPrefix();
	public void setNsPrefix(String prefix);
	
	public List<LClassifier> getTypes();
	public void addType(LClassifier type);
	public void removeType(LClassifier type);
	public Boolean containType(LClassifier type);
	public LClassifier getClassifierByID(int id);
	public LClassifier getClassifierByName(String name);
	
	
	public LFactory getFactory();
}
