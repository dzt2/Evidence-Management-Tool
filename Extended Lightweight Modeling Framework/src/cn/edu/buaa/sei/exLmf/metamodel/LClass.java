package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.List;

/*
 *	LClass: present class in LMF
 *	LClass {
 *		******** LModelElement *********
 *		-annotations
 *		******** LNamedElement *********
 *		-name: String
 *		******** LClassifier *********
 *		- classifier id: int	[identification in package space]
 *		- instance name: string [class name for generating code]		
 *		- default value: LObject[used in constructing default value in each related reference]
 *		- container: LPackage	[package space for managing it]
 *		******** LClass *********
 *		- isAbstract/isFinal
 *		- id_attribute
 *		- <> attributes 		[local/all]
 *		- <> references 		[local/all]
 *		- <id+name> features 	[local/all] 
 *	} 
 */
public interface LClass extends LClassifier{
	public List<LClass> getSuperTypes();
	public void addSuperType(LClass type);
	public void removeSuperType(LClass type);
	public Boolean isSuperOf(LClass type);
	public Boolean isSubOf(LClass type);
	
	public Boolean isAbstract();
	public Boolean isFinal();
	public void setAbstract(Boolean isAbstract);
	public void setFinal(Boolean isFinal);
	
	public LAttribute getIDAttribute();
	public void setIDAttribute(LAttribute attribute);
	
	public List<LAttribute> getAttributes();
	public List<LAttribute> getAllAttributes();
	public List<LReference> getReferences();
	public List<LReference> getAllReferences();
	public List<LStructuralFeature> getFeatures();
	public List<LStructuralFeature> getAllFeatures();
	
	public LStructuralFeature getFeatureByName(String name);
	public LStructuralFeature getFeatureByID(int id);
	public int[] getFeatureIDSet();
	
	public void addAttribute(LAttribute attribute);
	public void addReference(LReference reference);
	public void addFeature(LStructuralFeature feature);
	public Boolean containAttribute(LAttribute attribute);
	public Boolean containReference(LReference reference);
	public Boolean containFeature(LStructuralFeature feature);
	public void removeAttribute(LAttribute attribute);
	public void removeReference(LReference reference);
	public void removeFeature(LStructuralFeature feature);
	
	public LStructuralFeature removeFeatureByID(int id);
	public LStructuralFeature removeFeatureByName(String name);
}
