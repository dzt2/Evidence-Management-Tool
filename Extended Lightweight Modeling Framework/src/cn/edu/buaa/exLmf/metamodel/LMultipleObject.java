package cn.edu.buaa.exLmf.metamodel;

import java.util.Collection;
import java.util.Iterator;

public interface LMultipleObject extends LObject{
	public final int UNBOUNDED = -1;
	
	public LClassifier getParameterType();
	
	public int getLowerBound();
	public int getUpperBound();
	public Boolean isOrdered();
	public Boolean isUnique();
	
	public Collection<LObject> getAllObjects();
	public void addObject(LObject val);
	public void removeObject(LObject val);
	public Boolean containObject(LObject val);
	
	public LObject getByOrder(int i);
	public Iterator<LObject> getByUnordered();
	public Boolean validateBound();
}
