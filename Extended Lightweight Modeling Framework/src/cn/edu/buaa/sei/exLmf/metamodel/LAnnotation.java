package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.List;

/*
 *	LAnnotation -- Notation for Model Element
 *	LAnnotation{source,container,referencedElements}
 *	Container{name}-->referencedElements 
 */
public interface LAnnotation {
	public LModelElement getContainer();
	public void setContainer(LModelElement elm);
	
	public List<LModelElement> getReferencedElements();
	public void addReferencedElement(LModelElement element);
	public void removeReferencedElement(int i);
	public LModelElement getReferenceElement(int i);
	
	public void setSource(String source);
	public String getSource();
}
