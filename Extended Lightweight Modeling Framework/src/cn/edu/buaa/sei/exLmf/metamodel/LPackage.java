package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.List;

/*
 *	LPackage: model element that can package other elements.
 *	LPackage {
 *		************ LModelElement *************
 *		- annotations
 *		************ LNamedElement *************
 *		- name
 *		************ LPackage *************
 *		- nsUri
 *		- nsPrefix
 *		- <name> subPackages
 *		- <id & name> types
 *		- container
 *		- factory (not null)
 *	} 	
 * 
 */
public interface LPackage extends LNamedElement{
	public List<LPackage> getSubPackages();
	public void addSubPackage(LPackage pack);
	public void removeSubPackage(LPackage pack);
	public LPackage getSubPackageByName(String name);
	public boolean containSubPackage(LPackage p);
	
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
	
	public LPackage getContainer();
	public void setContainer(LPackage container);
	
	public LFactory getFactory();
}
