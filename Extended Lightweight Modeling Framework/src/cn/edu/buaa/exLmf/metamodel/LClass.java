package cn.edu.buaa.exLmf.metamodel;

import java.util.List;

public interface LClass extends LClassifier{
	public List<LClass> getSuperTypes();
	public LAttribute getIDAttribute();
	
	public List<LAttribute> getAttributes();
	public List<LAttribute> getAllAttributes();
	public List<LReference> getReferences();
	public List<LReference> getAllReferences();
	
	public List<LStructuralFeature> getFeatures();
	public List<LStructuralFeature> getAllFeatures();
	public LStructuralFeature getFeatureByName(String name);
	public LStructuralFeature getFeatureByID(int id);
	
	public void setIDAttribute(LAttribute attribute);
	public void addAttribute(LAttribute attribute);
	public void addReference(LReference reference);
	
	public LStructuralFeature removeFeature(int id);
}
