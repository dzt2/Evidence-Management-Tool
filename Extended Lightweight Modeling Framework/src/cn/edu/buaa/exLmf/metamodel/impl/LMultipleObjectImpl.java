package cn.edu.buaa.exLmf.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.exLmf.metamodel.LObject;

public class LMultipleObjectImpl extends LObjectImpl implements LMultipleObject{
	
	int lower=0,upper=UNBOUNDED;
	Boolean ordered = true,unique=false;
	
	List<LObject> array;
	Set<LObject> set;
	
	
	LMultipleObjectImpl(LClassifier type,int lower,int upper,Boolean ordered,Boolean unique) {
		super(type);
		if(lower<0){
			try {
				throw this.getException("LMultipleObjectImpl(type,lower,upper,ordered,unique)", 
						"lower", "lower < 0");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(upper<0&&upper!=UNBOUNDED){
			try {
				throw this.getException("LMultipleObjectImpl(type,lower,upper,ordered,unique)", 
						"upper", upper+" is invalid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if(upper>0&&upper<lower){
			try {
				throw this.getException("LMultipleObjectImpl(type,lower,upper,ordered,unique)", 
						"upper", "The range is invalid: "+lower+"--"+upper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		this.lower=lower; this.upper=upper;
		this.ordered=ordered; this.unique=unique;
		
		if(!this.ordered&&this.unique)
			set = new HashSet<LObject>();
		else
			array = new ArrayList<LObject>();
	}

	@Override
	public LClassifier getParameterType() {return this.type;}

	@Override
	public int getLowerBound() {return this.lower;}
	@Override
	public int getUpperBound() {return this.upper;}
	@Override
	public Boolean isOrdered() {return this.ordered;}
	@Override
	public Boolean isUnique() {return this.unique;}

	@Override
	public Collection<LObject> getAllObjects() {
		if(set!=null)return set;
		else if(array!=null)return array;
		else{
			try {
				throw this.getException("getAllObjects()", "contents", "Un-Initialization");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	@Override
	public void addObject(LObject val) {
		if(val==null){
			try {
				throw this.getException("addObject(val)", "val", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(val.type()!=this.type){
			try {
				throw this.getException("addObject(val)", "val.type", "Classifier is incompatible with parameter type");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(this.unique){
			if(this.ordered){
				if(this.array.contains(val)){
					try {
						throw this.getException("addObject(val)", "val", "Unique Array has contained the same elements");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				else{
					this.array.add(val);
				}
			}
			else{
				if(this.set.contains(val)){
					try {
						throw this.getException("addObject(val)", "val", "Unique Set has contained the same elements");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				else
					this.set.add(val);
			}
		}
		else{
			if(this.ordered){
				this.array.add(val);
			}
			else{
				int n = this.array.size();
				Random r = new Random();
				int i = (int)(r.nextDouble()*(n+1));
				this.array.add(i, val);
			}
		}
	}
	@Override
	public void removeObject(LObject val) {
		if(val==null){
			try {
				throw this.getException("removeObject(val)", "val", "Null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(val.type()!=this.type){
			try {
				throw this.getException("removeObject(val)", "val", "Undefined as classifier incompatibility");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(!this.ordered&&this.unique){
			if(!this.set.contains(val)){
				try {
					throw this.getException("removeObject(val)", "val", "Undefined in set");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			else
				this.set.remove(val);
		}
		else{
			if(!this.array.contains(val)){
				try {
					throw this.getException("removeObject(val)", "val", "Undefined in set");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			else
				this.array.remove(val);
		}
	}
	@Override
	public Boolean containObject(LObject val) {
		if(val==null)return false;
		if(val.type()!=this.type)return false;
		
		if(this.unique&&!this.ordered)
			return this.set.contains(val);
		else return this.array.contains(val);
	}

	@Override
	public LObject getByOrder(int i) {
		if(!this.ordered){
			try {
				throw this.getException("getByOrder(i)", "this.order", 
						"Inordered Set cannot be assess by index "+i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		if(i<0||i>=this.array.size()){
			try {
				throw this.getException("getByOrder(i)", "i", 
						i+" is out of range: size="+this.array.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		return this.array.get(i);
	}
	@Override
	public Iterator<LObject> getByUnordered() {
		if(this.ordered){
			try {
				throw this.getException("getByUnordered()", "this.order", 
						"Orderred array cannot be assess through unordered functions");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if(this.unique)
			return this.set.iterator();
		else
			return this.array.iterator();
	}

	@Override
	public Boolean validateBound() {
		int n = -1;
		if(this.array!=null)n = this.array.size();
		else if(this.set!=null)n = this.set.size();
		else{
			try {
				throw this.getException("validateBound()", "content", "Un-Initialization");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(n<this.lower){
			try {
				throw this.getException("validateBound()", "size--lower", "Size "+n+" < Lower "+this.lower);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(n>this.upper&&this.upper!=UNBOUNDED){
			try {
				throw this.getException("validateBound()", "size--lower", "Size "+n+" > Upper "+this.upper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}

}
