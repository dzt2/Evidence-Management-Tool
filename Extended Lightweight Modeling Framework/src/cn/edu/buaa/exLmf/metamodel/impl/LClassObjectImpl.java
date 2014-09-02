package cn.edu.buaa.exLmf.metamodel.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.exLmf.metamodel.LObject;
import cn.edu.buaa.exLmf.metamodel.LStructuralFeature;

public class LClassObjectImpl extends LObjectImpl implements LClassObject{
	Map<LStructuralFeature,LObject> feature_val = new HashMap<LStructuralFeature,LObject>();
	Map<LStructuralFeature,Boolean> status_map = new HashMap<LStructuralFeature,Boolean>();
	
	LClassObjectImpl(LClass type) {
		super(type);
		
		/*Initialization*/
		List<LStructuralFeature> features = type.getAllFeatures();
		for(int i=0;i<features.size();i++){
			status_map.put(features.get(i), false);
			if(features.get(i).getUpperBound()>1||
					features.get(i).getUpperBound()==LMultipleObject.UNBOUNDED){
				LStructuralFeature feature = features.get(i);
				LMultipleObject val = new LMultipleObjectImpl(feature.getType(),feature.getLowerBound(),
						feature.getUpperBound(),feature.isOrdered(),feature.isUnique());
				feature_val.put(features.get(i), val);
			}
			else{
				feature_val.put(features.get(i), features.get(i).getDefaultValue());
			}
			
		}
	}

	@Override
	public LClass getType() {return (LClass) this.type;}

	@Override
	public LObject get(LStructuralFeature feature) {
		if(feature==null){
			try {
				throw this.getException("get(feature)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass ctype = (LClass) this.type;
		if(!this.feature_val.containsKey(feature)){
			try {
				throw this.getException("get(feature)", "feature", "Class <"+ctype.getName()
						+"> does not define feature <"+feature.getName()+":"+feature.getFeatureID()+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.feature_val.get(feature);
	}
	@Override
	public void set(LStructuralFeature feature, LObject value) {
		if(feature==null){
			try {
				throw this.getException("set(feature,value)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		LClass ctype = (LClass) this.type;
		if(!this.status_map.containsKey(feature)){
			try {
				throw this.getException("set(feature,value)", "feature", "Class <"+ctype.getName()
						+"> does not define feature <"+feature.getName()+":"+feature.getFeatureID()+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(value!=null&&value.type()!=feature.getType()){
			try {
				throw this.getException("set(feature,value)", "feature-value", "Value Type <"+value.type().getName()
						+"> does not match <"+feature.getType().getName()+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(!feature.isChangable()&&
				this.status_map.get(feature)==false){
			try {
				throw this.getException("set(feature,value)", "feature", "try to update unchangable feature value");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(feature.getUpperBound()>1||feature.getUpperBound()==LMultipleObject.UNBOUNDED){
			/*LMultipleObject val = (LMultipleObject) this.feature_val.get(feature);
			val.addObject(value);*/
			try {
				throw this.getException("set(feature,value)", "feature-value", "Multiple Object Set cannot be set directly");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		else{
			this.feature_val.put(feature, value);
		}
		this.status_map.put(feature, true);
	}
	@Override
	public Boolean isSet(LStructuralFeature feature) {
		if(feature==null){
			try {
				throw this.getException("isSet(feature)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		LClass ctype = (LClass) this.type;
		if(!this.status_map.containsKey(feature)){
			try {
				throw this.getException("isSet(feature)", "feature", "Class <"+ctype.getName()
						+"> does not define feature <"+feature.getName()+":"+feature.getFeatureID()+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return this.status_map.get(feature);
	}
	@Override
	public void unSet(LStructuralFeature feature) {
		if(feature==null){
			try {
				throw this.getException("unSet(feature)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		LClass ctype = (LClass) this.type;
		if(!this.status_map.containsKey(feature)){
			try {
				throw this.getException("unSet(feature)", "feature", "Class <"+ctype.getName()
						+"> does not define feature <"+feature.getName()+":"+feature.getFeatureID()+">");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.status_map.put(feature, false);
	}

	@Override
	public void add(LStructuralFeature feature, LObject val) {
		if(feature==null||(feature.getUpperBound()<=1
				&&feature.getUpperBound()!=LMultipleObject.UNBOUNDED)){
			try {
				throw this.getException("add(feature,val)","feature", "feature is not a multiple feature");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(!this.feature_val.containsKey(feature)){
			try {
				throw this.getException("add(feature,val)","feature", feature.getName()+" is not defined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		LMultipleObject list = (LMultipleObject) this.feature_val.get(feature);
		list.addObject(val);
	}

	@Override
	public void remove(LStructuralFeature feature, LObject val) {
		if(feature==null||!this.feature_val.containsKey(feature)){
			try {
				throw this.getException("remove(feature,val)", "feature", "Undefined");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(feature.getUpperBound()>1||feature.getUpperBound()==LMultipleObject.UNBOUNDED){
			LMultipleObject list = (LMultipleObject) this.feature_val.get(feature);
			list.removeObject(val);
		}
		else{
			this.feature_val.put(feature, null);
		}
	}
}
