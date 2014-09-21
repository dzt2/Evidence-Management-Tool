package cn.edu.buaa.sei.exLmf.metamodel.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LClassObject;
import cn.edu.buaa.sei.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.sei.exLmf.metamodel.LObject;
import cn.edu.buaa.sei.exLmf.metamodel.LStructuralFeature;

public class SimpleLClassObject extends LObjectImpl implements LClassObject{
	static Map<LClass,List<LStructuralFeature>> type_feature_map = 
			new HashMap<LClass,List<LStructuralFeature>>();
	
	Boolean[] flags;
	LObject[] values;

	SimpleLClassObject(LClass type) {
		super(type);
		
		List<LStructuralFeature> fs = type_feature_map.get(type);
		if(!type_feature_map.containsKey(type)){
			fs = type.getAllFeatures();
			type_feature_map.put(type, fs);
		}
		
		int n = fs.size();
		this.flags = new Boolean[n];
		this.values = new LObject[n];
		for(int i=0;i<n;i++){
			LStructuralFeature f = fs.get(i);
			this.flags[i]=false;
			
			if(f.getUpperBound()>1||f.getUpperBound()==LMultipleObject.UNBOUNDED){
				this.values[i]=new LMultipleObjectImpl(f.getType(),f.getLowerBound(),
						f.getUpperBound(),f.isOrdered(),f.isUnique());
			}
			else{this.values[i]=f.getDefaultValue();}
		}
	}
	
	/**
	 * 
	 *	int getIndex(LStructuralFeature)
	 *		- description: return the index of feature of type of this object.
	 *		- failure condition:
	 *			-a. !this.type.containFeature(feature): static feature lost
	 *			-b. !type_feature_map.containKey(type): un-registered type in static map
	 *			-c. !type_feature_map.get(type).contain(feature): dynamic feature lost.
	 */
	int getIndex(LStructuralFeature feature){
		LClass type = (LClass) this.type;
		if(!type.containFeature(feature)){
			try {
				throw this.getException("getIndex(feature)", "feature", "Undefined [Static]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
		
		List<LStructuralFeature> fs = type_feature_map.get(type);
		if(fs==null){
			try {
				throw this.getException("getIndex(feature)", "type", "Type \""+type.getName()+"\" register failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
		
		int i=0;
		for(i=0;i<fs.size();i++)
			if(fs.get(i)==feature)break;
		
		if(i>=fs.size()){
			try {
				throw this.getException("getIndex(feature)", "feature", "Undefined [Dynamic]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
		
		return i;
	}
	
	@Override
	public LClass getType() {return (LClass) this.type;}

	@Override
	public LObject get(LStructuralFeature feature) {
		int i = this.getIndex(feature);
		if(i<0)return null;
		else return this.values[i];
	}
	@Override
	public void set(LStructuralFeature feature, LObject value) {
		/**
		 *	set(feature,value)
		 *		- can only set single feature (0..1) not a multiple feature (m...n)|(n...*) 
		 */
		if(feature.getUpperBound()>1||feature.getUpperBound()==LMultipleObject.UNBOUNDED){
			try {
				throw this.getException("set(feature,value)", "feature", "Multiple Object cannot be set [change to add/remove].");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(value!=null&&feature.getType()!=value.type()){
			if(feature.getType() instanceof LClass&&value.type() instanceof LClass){
				LClass ftype = (LClass) feature.getType();
				LClass vtype = (LClass) value.type();
				if(!ftype.isSuperOf(vtype)){
					try {
						throw this.getException("set(feature,value)", "feature", "Wrong Type Match: \""+this.type.getName()+"\" --- \""+value.type().getName()+"\"");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
			}
			else{
				try {
					throw this.getException("set(feature,value)", "feature", "Wrong Type Match: \""+this.type.getName()+"\" --- \""+value.type().getName()+"\"");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		int i = this.getIndex(feature);
		this.values[i]=value;
		this.flags[i]=true;
	}
	@Override
	public Boolean isSet(LStructuralFeature feature) {
		int i = this.getIndex(feature);
		if(i<0)return null;
		else return this.flags[i];
	}
	@Override
	public void unSet(LStructuralFeature feature) {
		int i = this.getIndex(feature);
		if(i>=0)this.flags[this.getIndex(feature)]=false;
	}

	@Override
	public void add(LStructuralFeature feature, LObject val) {
		if(feature==null){
			try {
				throw this.getException("add(feature,value)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(feature.getUpperBound()<=1&&feature.getUpperBound()!=LMultipleObject.UNBOUNDED){
			try {
				throw this.getException("add(feature,value)", "feature", "Multiple Object cannot be set [change to add/remove].");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(val==null){
			try {
				throw this.getException("add(feature,value)", "value", "Null cannot be added into Multiple Object");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		/*if(feature.getType()!=val.type()){
			try {
				throw this.getException("add(feature,value)", "value", "Wrong Type Match: \""+this.type.getName()+"\" --- \""+val.type().getName()+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}*/
		
		int i = this.getIndex(feature);
		LMultipleObject list = (LMultipleObject) this.values[i];
		list.addObject(val);
		this.flags[i]=true;
	}
	@Override
	public void remove(LStructuralFeature feature, LObject val) {
		if(feature==null){
			try {
				throw this.getException("remove(feature,value)", "feature", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(feature.getUpperBound()<=1&&feature.getUpperBound()!=LMultipleObject.UNBOUNDED){
			try {
				throw this.getException("remove(feature,value)", "feature", "Multiple Object cannot be set [change to add/remove].");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(val==null){
			try {
				throw this.getException("remove(feature,value)", "value", "Null cannot be in Multiple Object");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		/*if(feature.getType()!=val.type()){
			try {
				throw this.getException("remove(feature,value)", "value", "Wrong Type Match: \""+this.type.getName()+"\" --- \""+val.type().getName()+"\"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}*/
		
		int i = this.getIndex(feature);
		LMultipleObject list = (LMultipleObject) this.values[i];
		list.removeObject(val);
		this.flags[i]=true;
	}
}
