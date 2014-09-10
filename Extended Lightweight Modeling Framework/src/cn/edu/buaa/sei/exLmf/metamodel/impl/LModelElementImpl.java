package cn.edu.buaa.sei.exLmf.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.sei.exLmf.metamodel.LAnnotation;
import cn.edu.buaa.sei.exLmf.metamodel.LModelElement;

public abstract class LModelElementImpl implements LModelElement{
	
	List<LAnnotation> annotations = new ArrayList<LAnnotation>();
	
	/*
	 *	Tool Functions for all model elements. 
	 */
	Exception getException(String func,String arg,String reason){
		return LMFException.create("LMFException", this.getClass().getName(), func, arg, reason);
	}

	/*
	 *	Core Functions 
	 */
	@Override
	public List<LAnnotation> getAnnotations() {
		// TODO Auto-generated method stub
		return this.annotations;
	}

	@Override
	public void addAnnotation(LAnnotation annotation) {
		if(annotation==null){
			try {
				throw this.getException("addAnnotation(annotation)", "annotation", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		annotation.setContainer(this);
		this.annotations.add(annotation);
	}
	@Override
	public LAnnotation getAnnotation(int i) {
		if(i<0||i>=this.annotations.size()){
			try {
				throw this.getException("getAnnotation(i)", "i", i+" has been out of range");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.annotations.get(i);
	}
	@Override
	public void removeAnnotation(int i) {
		if(i<0||i>=this.annotations.size()){
			try {
				throw this.getException("getAnnotation(i)", "i", i+" has been out of range");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.annotations.remove(i);
	}

}
