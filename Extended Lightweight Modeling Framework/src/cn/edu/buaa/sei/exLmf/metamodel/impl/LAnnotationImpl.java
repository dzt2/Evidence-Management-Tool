package cn.edu.buaa.sei.exLmf.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.exLmf.metamodel.LAnnotation;
import cn.edu.buaa.sei.exLmf.metamodel.LModelElement;

public class LAnnotationImpl implements LAnnotation{
	
	LModelElement container;
	List<LModelElement> references = new ArrayList<LModelElement>();
	String source;
	
	LAnnotationImpl(String source){
		this.source = source;
	}
	
	@Override
	public LModelElement getContainer() {return this.container;}
	public void setContainer(LModelElement container){this.container=container;}
	
	@Override
	public List<LModelElement> getReferencedElements() {return this.references;}

	@Override
	public String getSource() {return this.source;}
	public void setSource(String source){this.source=source;}

	@Override
	public void addReferencedElement(LModelElement element) {
		if(!this.references.contains(element))this.references.add(element);
	}
	@Override
	public void removeReferencedElement(int i) {
		if(i<0||i>=this.references.size()){
			LMFException ex = LMFException.create("LMFException", LAnnotationImpl.class.getName(), 
					"remoceReferencedElement(i)", "...",i+"has been out of range: size="+this.references.size());
			ex.pushReason(i+"has been out of range: size="+this.references.size());
			try {
				throw ex;
			} catch (LMFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.references.remove(i);
	}
	@Override
	public LModelElement getReferenceElement(int i) {
		// TODO Auto-generated method stub
		if(i<0||i>=this.references.size()){
			LMFException ex = LMFException.create("LMFException", LAnnotationImpl.class.getName(), 
					"getReferencedElement(i)", "...",i+"has been out of range: size="+this.references.size());
			try {
				throw ex;
			} catch (LMFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.references.get(i);
	}
	
}
