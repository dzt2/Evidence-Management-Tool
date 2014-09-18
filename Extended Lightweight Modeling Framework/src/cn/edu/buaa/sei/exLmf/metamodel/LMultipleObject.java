package cn.edu.buaa.sei.exLmf.metamodel;

import java.util.Collection;
import java.util.Iterator;


/*
 *	LMultipleObject {
 *		- parameter_type (type)
 *		- lower/upper
 *		- isUnique/isOrdered
 *		- values (ordered-->list;unique+!ordered-->set;else-->list)
 *	} 
 */
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
	
	/*
	 *	!isOredered ==> call getByOrder(i) ==> Exception 
	 *	isOrdered ==> call getByUnordered() ==> Exception
	 *	validateBound() ==> check whether the current number of instances in set satisfy the constraints of upper/lower
	 */
	public LObject getByOrder(int i);
	public Iterator<LObject> getByUnordered();
	public Boolean validateBound();
}
