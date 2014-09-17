package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.List;

/*
 *	LModelElement: Model Element for exLMF
 *	LModelElement{annotations}
 *	a.annotations[i].container==a;
 *
 * 	LModelElement(1)--(1)Annotation{source:string}(1)--(0..*)LModelElement
 */
public interface LModelElement {
	public List<LAnnotation> getAnnotations();
	public void addAnnotation(LAnnotation annotation);
	public LAnnotation getAnnotation(int i);
	public void removeAnnotation(int i);
}
