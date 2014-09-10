package cn.edu.buaa.exLmf.metamodel.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;
import cn.edu.buaa.exLmf.metamodel.LStructuralFeature;

public class LClassImpl extends LClassifierImpl implements LClass{
	
	List<LClass> supers = new ArrayList<LClass>();
	List<LAttribute> attributes = new ArrayList<LAttribute>();
	List<LReference> references = new ArrayList<LReference>();
	List<LStructuralFeature> features = new ArrayList<LStructuralFeature>();
	
	Map<String,LStructuralFeature> name_feature = new HashMap<String,LStructuralFeature>();
	Map<Integer,LStructuralFeature> id_feature = new HashMap<Integer,LStructuralFeature>();
	
	//List<LAttribute> all_attrs = new ArrayList<LAttribute>();
	//List<LReference> all_refs = new ArrayList<LReference>();
	
	LAttribute id_attr=null;

	public LClassImpl(String name,LPackage container){super(name,container);}
	
	@Override
	public List<LClass> getSuperTypes() {return this.supers;}
	@Override
	public void addSuperType(LClass type) {
		if(type==null){
			try {
				throw this.getException("addSuperType(type)", "type", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(this.supers.contains(type))return;
		if(this.isSuperOf(type)){
			try {
				throw this.getException("addSuperType(type)", "type", 
						"Circle of generalization is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(type.isFinal()){
			try {
				throw this.getException("addSuperType(type)", "type", 
						"Final type \""+type.getName()+"\" cannot be generalized to sub-class");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		this.supers.add(type);
	}
	@Override
	public void removeSuperType(LClass type) {
		if(!this.supers.contains(type)){
			try {
				throw this.getException("removeSuperType(type)", "type", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.supers.remove(type);
	}
	@Override
	public Boolean isSuperOf(LClass type) {
		if(type==null)return false;
		
		if(type.getSuperTypes().contains(this))return true;
		else{
			for(int i=0;i<type.getSuperTypes().size();i++)
				if(this.isSuperOf(type.getSuperTypes().get(i)))
					return true;
		}
		
		return false;
	}
	@Override
	public Boolean isSubOf(LClass type) {
		if(type==null)return false;
		return type.isSuperOf(this);
	}

	@Override
	public LAttribute getIDAttribute() {return this.id_attr;}
	@Override
	public void setIDAttribute(LAttribute attribute) {
		this.id_attr=attribute;
		this.addAttribute(attribute);
	}

	@Override
	public List<LAttribute> getAttributes() {return this.attributes;}
	@Override
	public List<LAttribute> getAllAttributes() {
		List<LAttribute> alls = new ArrayList<LAttribute>();
		
		alls.addAll(this.attributes);
		for(int i=0;i<this.supers.size();i++)
			alls.addAll(this.supers.get(i).getAllAttributes());
		
		return alls;
	}

	@Override
	public List<LReference> getReferences() {return this.references;}
	@Override
	public List<LReference> getAllReferences() {
		List<LReference> alls = new ArrayList<LReference>();
		
		alls.addAll(this.references);
		for(int i=0;i<this.supers.size();i++)
			alls.addAll(this.supers.get(i).getAllReferences());
		
		return alls;
	}

	@Override
	public List<LStructuralFeature> getFeatures() {return this.features;}
	@Override
	public List<LStructuralFeature> getAllFeatures() {
		List<LStructuralFeature> alls = new ArrayList<LStructuralFeature>();
		
		alls.addAll(this.features);
		for(int i=0;i<this.supers.size();i++){
			alls.addAll(this.supers.get(i).getAllFeatures());
		}
		
		return alls;
	}

	@Override
	public LStructuralFeature getFeatureByName(String name) {
		if(name==null)return null;
		else if(this.name_feature.containsKey(name)) 
			return this.name_feature.get(name);
		else
			for(int i=0;i<this.supers.size();i++){
				LStructuralFeature f = this.supers.get(i).getFeatureByName(name);
				if(f!=null)return f;
			}
		return null;
	}
	@Override
	public LStructuralFeature getFeatureByID(int id) {
		if(this.id_feature.containsKey(id))return this.id_feature.get(id);
		else{
			/*for(int i=0;i<this.supers.size();i++){
				LStructuralFeature f = this.supers.get(i).getFeatureByID(id);
				if(f!=null)return f;
			}*/
			return null;
		}
	}
	@Override
	public int[] getFeatureIDSet() {
		int n = this.id_feature.size();
		int[] ids = new int[n];
		int i = 0;
		for(Integer id:id_feature.keySet())
			ids[i++] = id;
		return ids;
	}
	
	/*
	 *	Only add features in local space 
	 */
	void _addFeature(LStructuralFeature feature){
		if(feature==null){
			try {
				throw this.getException("_addFeature(feature)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		// including the super classes.
		if(this.containFeature(feature))return;
		
		int fid = feature.getFeatureID();
		String name = feature.getName();
		
		if(this.name_feature.containsKey(name)){
			try {
				throw this.getException("_addFeature(feature)", "feature.name", 
						name+ " has been defined in feature namespace");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		if(this.id_feature.containsKey(fid)){
			try {
				throw this.getException("_addFeature(feature)", "feature.id", 
						fid+ " has been defined in feature id-space");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		this.features.add(feature);
		feature.setContainer(this);
		this.name_feature.put(name, feature);
		this.id_feature.put(fid, feature);
	}
	@Override
	public void addAttribute(LAttribute attribute) {
		this._addFeature(attribute);
		if(!this.attributes.contains(attribute)){
			this.attributes.add(attribute);
		}
	}
	@Override
	public void addReference(LReference reference) {
		this._addFeature(reference);
		if(!this.references.contains(reference))
			this.references.add(reference);
		
	}
	@Override
	public void addFeature(LStructuralFeature feature) {
		if(feature instanceof LAttribute)
			this.addAttribute((LAttribute) feature);
		else if(feature instanceof LReference)
			this.addReference((LReference) feature);
		else{
			try {
				throw this.getException("addFeature(feature)", "feature", 
						feature.getClass().getName()+" behavior is not defined");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Boolean containAttribute(LAttribute attribute) {
		if(this.attributes.contains(attribute))return true;
		else{
			for(int i=0;i<this.supers.size();i++)
				if(this.supers.get(i).containAttribute(attribute))
					return true;
			return false;
		}
	}
	@Override
	public Boolean containReference(LReference reference) {
		if(this.references.contains(reference))return true;
		else{
			for(int i=0;i<this.supers.size();i++)
				if(this.supers.get(i).containReference(reference))
					return true;
			return false;
		}
	}
	@Override
	public Boolean containFeature(LStructuralFeature feature) {
		if(this.features.contains(feature))return true;
		else{
			for(int i=0;i<this.supers.size();i++)
				if(this.supers.get(i).containFeature(feature))
					return true;
			return false;
		}
	}

	/*	Adding or Removing only limited in the local attributes not including super classes*/
	@Override
	public void removeAttribute(LAttribute attribute) {
		if(attribute==null||!this.attributes.contains(attribute)){
			try {
				throw this.getException("removeAttribute(attribute)", "attribute", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		String name = attribute.getName();
		int id = attribute.getFeatureID();
		
		this.name_feature.remove(name);
		this.id_feature.remove(id);
		this.features.remove(attribute);
		this.attributes.remove(attribute);
		attribute.setContainer(null);
	}
	@Override
	public void removeReference(LReference reference) {
		if(reference==null||!this.references.contains(reference)){
			try {
				throw this.getException("removeReference(reference)","reference", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		String name = reference.getName();
		int id = reference.getFeatureID();
		
		this.name_feature.remove(name);
		this.id_feature.remove(id);
		this.features.remove(reference);
		this.references.remove(reference);
		reference.setContainer(null);
	}
	@Override
	public void removeFeature(LStructuralFeature feature) {
		if(feature==null){
			try {
				throw this.getException("removeFeature(feature)", "feature", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(feature instanceof LAttribute)
			this.removeAttribute((LAttribute) feature);
		else if(feature instanceof LReference)
			this.removeReference((LReference) feature);
		else{
			try {
				throw this.getException("removeFeature(feature)", "feature", 
						feature.getClass().getName()+" behavior is not defined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*Only remove the local attribute (would no affect the super classes)*/
	@Override
	public LStructuralFeature removeFeatureByID(int id) {
		if(!this.id_feature.containsKey(id)){
			try {
				throw this.getException("removeFeatureByID(id)","id", id + " Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LStructuralFeature f = this.id_feature.get(id);
		this.removeFeature(f);
		return f;
	}
	@Override
	public LStructuralFeature removeFeatureByName(String name) {
		if(!this.name_feature.containsKey(name)){
			try {
				throw this.getException("removeFeatureByName(name)","name", name + " Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LStructuralFeature f = this.name_feature.get(name);
		this.removeFeature(f);
		return f;
	}

	Boolean isAbstract=false;
	Boolean isFinal=false;
	@Override
	public Boolean isAbstract() {return this.isAbstract;}
	@Override
	public Boolean isFinal() {return this.isFinal;}
	@Override
	public void setAbstract(Boolean isAbstract) {this.isAbstract=isAbstract;}
	@Override
	public void setFinal(Boolean isFinal) {this.isFinal=isFinal;}

}
