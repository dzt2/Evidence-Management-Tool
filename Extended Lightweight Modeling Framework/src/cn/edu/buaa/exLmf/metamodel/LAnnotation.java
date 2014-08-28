package cn.edu.buaa.exLmf.metamodel;

import java.util.List;

public interface LAnnotation {
	public LModelElement getContainer();
	public List<LModelElement> getReferencedElements();
}
