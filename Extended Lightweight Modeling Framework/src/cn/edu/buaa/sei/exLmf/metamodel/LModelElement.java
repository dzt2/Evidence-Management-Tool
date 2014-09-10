package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.List;

public interface LModelElement {
	public List<LAnnotation> getAnnotations();
	public void addAnnotation(LAnnotation annotation);
	public LAnnotation getAnnotation(int i);
	public void removeAnnotation(int i);
}
