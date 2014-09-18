package cn.edu.buaa.sei.exLmf.metamodel;

/*
 *	LEnumLiteral {
 *		******** LModelElement *********
 *		- annotations
 *		******** LNamedElement *********
 *		- name: String
 *		******** LTypedElement *********
 *		- type: LClassifier
 *		- isOrdered/isUnique: boolean	(M)
 *		- upper/lower: int				(M)
 *		******** LStructuralFeature *********
 *		- container: LClassifier
 *		- isChangable: boolean
 *		- feature id: int {identification in container space}
 *		- default value: LObject (used in constructing attribute/reference values when creating LObject)
 *	 	******** LEnumLiteral *********
 *		- literal: String [--> name]
 *		- value: int
 *	} 
 * 
 */
public interface LEnumLiteral extends LStructuralFeature{
	public int getValue();
	public void setValue(int value);
	public String getLiteral();
	public void setLiteral(String literal);
}
